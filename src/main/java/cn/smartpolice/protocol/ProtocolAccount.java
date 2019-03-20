package cn.smartpolice.protocol;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.smartpolice.VO.RegAccount;
import cn.smartpolice.VO.RegAppAccount;
import cn.smartpolice.VO.RegDevAccount;
import cn.smartpolice.dao.*;
import cn.smartpolice.entity.DeviceInf;
import cn.smartpolice.entity.UserInf;
import cn.smartpolice.tools.ApplicationContextHelper;
import org.apache.mina.core.buffer.IoBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.smartpolice.entity.DeviceLog;
import cn.smartpolice.entity.UserLog;
import cn.smartpolice.tools.JsonAnalysis;
import cn.smartpolice.workbean.PacketInfo;
import cn.smartpolice.workbean.SysInfo;
import cn.smartpolice.workbean.UserNode;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

/**
 * @author maxiaolin
 * cmd=2  账户管理协议
 * 注销账号还有很多东西未定义，故没有优化
 */
@Component
public class ProtocolAccount extends ProtocolBase implements ConstParam {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private DeviceInfMapper deviceDao;

    @Autowired
    private DeviceLogMapper devLogDao;
    @Autowired
    private UserInfMapper userDao;
    @Autowired
    private UserLogMapper userLogDao;

    private RegAccount regAccount = new RegAccount();
    private RegAppAccount regAppAccount = new RegAppAccount();
    private RegDevAccount regDevAccount = new RegDevAccount();
    private int errorPktState;// 标记返回错误报文类型
    private int sid; // 查询时需要返回的sid
    private boolean infoComplete = false;
    //注销成功返回日期
    private Date offDate;
    private UserNode userNode;


    void ParsePktProto(PacketInfo packetInfo) {
        try {
            logger.debug("进入账户管理协议-->开始协议解析");
            super.revPacket = packetInfo;
            JsonAnalysis jsonAnalysis = new JsonAnalysis();
            String data = packetInfo.getData();
            if (jsonAnalysis.getValue(data, "SNUM") != null) {
                regAccount.setSnum(jsonAnalysis.getValue(data, "SNUM"));
            }
            if (jsonAnalysis.getValue(data, "SVER") != null) {
                regAccount.setSver(jsonAnalysis.getValue(data, "SVER"));
            }
            if (jsonAnalysis.getValue(data, "USER") != null) {
                regAccount.setUser(jsonAnalysis.getValue(data, "USER"));
            }
            if (jsonAnalysis.getValue(data, "PASSWORD") != null) {
                regAccount.setPassword(jsonAnalysis.getValue(data, "PASSWORD"));
            }
            if (jsonAnalysis.getValue(data, "INFO") != null) {
                regAccount.setInfo(jsonAnalysis.getValue(data, "INFO"));
            }
            if (jsonAnalysis.getValue(data, "LINK") != null) {
                regAccount.setLink(Integer.parseInt(jsonAnalysis.getValue(data, "LINK")));
            }
            // 获得设备消息节点
            if (revPacket.getSort() == ConstParam.SORT_2) {
                userNode = revPacket.getDevNode();
            }
            // 获得用户消息节点
            if (revPacket.getSort() == ConstParam.SORT_0) {
                userNode = revPacket.getAppNode();
            }
            // 设备注册信息解析
            if (revPacket.getSort() == ConstParam.SORT_2 && regAccount.getInfo() != null && revPacket.getType() != ConstParam.TYPE_5) {
                if (jsonAnalysis.getValue(regAccount.getInfo(), "SEQ") != null) {
                    regDevAccount.setDevSerial(jsonAnalysis.getValue(regAccount.getInfo(), "SEQ"));

                }
                if (jsonAnalysis.getValue(regAccount.getInfo(), "BARCODE") != null) {
                    regDevAccount.setDevCode(jsonAnalysis.getValue(regAccount.getInfo(), "BARCODE"));

                }
                if (jsonAnalysis.getValue(regAccount.getInfo(), "LATI") != null) {
                    regDevAccount.setDevLatitude(jsonAnalysis.getValue(regAccount.getInfo(), "LATI"));

                }
                if (jsonAnalysis.getValue(regAccount.getInfo(), "LONGI") != null) {
                    regDevAccount.setDevLongitude(jsonAnalysis.getValue(regAccount.getInfo(), "LONGI"));

                }
                if (jsonAnalysis.getValue(regAccount.getInfo(), "MAX") != null) {
                    regDevAccount.setDevMaxConLimit(Integer.parseInt(jsonAnalysis.getValue(regAccount.getInfo(), "MAX"))); //容错处理，若MAX为空，使用Integer.parseInt()时将抛出异常
                } else {
                    regDevAccount.setDevMaxConLimit(ConstParam.DevMaxConLimit);
                }
                if (jsonAnalysis.getValue(regAccount.getInfo(), "CLASS") != null) {
                    regDevAccount.setDevType(jsonAnalysis.getValue(regAccount.getInfo(), "CLASS"));

                }
                if (jsonAnalysis.getValue(regAccount.getInfo(), "PHONE") != null) {
                    regDevAccount.setDevMphone(jsonAnalysis.getValue(regAccount.getInfo(), "PHONE"));

                }
                if (regDevAccount.getDevSerial() != null && regDevAccount.getDevCode() != null && regDevAccount.getDevLongitude() != null && regDevAccount.getDevLatitude() != null && regDevAccount.getDevType() != null
                        && regDevAccount.getDevMphone() != null && regDevAccount.getDevMaxConLimit() != -1) {//判断info是否完整，在报文注册时有用
                    infoComplete = true;
                }
            }
            // app注册信息解析
            if (revPacket.getSort() == ConstParam.SORT_0 && regAccount.getInfo() != null && revPacket.getType() != ConstParam.TYPE_5) {
                if (jsonAnalysis.getValue(regAccount.getInfo(), "LIMIT") != null) {
                    regAppAccount.setAppAuthority(jsonAnalysis.getValue(regAccount.getInfo(), "LIMIT"));

                }

                if (jsonAnalysis.getValue(regAccount.getInfo(), "CLASS") != null) {
                    regAppAccount.setAppType(jsonAnalysis.getValue(regAccount.getInfo(), "CLASS"));

                }
                if (jsonAnalysis.getValue(regAccount.getInfo(), "NAME") != null) {
                    regAppAccount.setAppName(jsonAnalysis.getValue(regAccount.getInfo(), "NAME"));

                }
                if (jsonAnalysis.getValue(regAccount.getInfo(), "BIRTH") != null) {
                    try {
                        regAppAccount.setAppBirth(new SimpleDateFormat("yyyy-MM-dd").parse(jsonAnalysis.getValue(regAccount.getInfo(), "BIRTH")));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (jsonAnalysis.getValue(regAccount.getInfo(), "SEX") != null) {
                    logger.debug("sex != null--》" + jsonAnalysis.getValue(regAccount.getInfo(), "SEX"));
                    if (jsonAnalysis.getValue(regAccount.getInfo(), "SEX").equals(ConstParam.MAN)) {
                        logger.info("是男的");
                        regAppAccount.setAppSex(ConstParam.MAN);
                    } else {
                        logger.debug("性别-->" + jsonAnalysis.getValue(regAccount.getInfo(), "SEX"));
                        regAppAccount.setAppSex(ConstParam.WOMAN);
                    }
                }
                if (jsonAnalysis.getValue(regAccount.getInfo(), "EMAIL") != null) {
                    regAppAccount.setAppMail(jsonAnalysis.getValue(regAccount.getInfo(), "EMAIL"));

                }
                if (jsonAnalysis.getValue(regAccount.getInfo(), "PHONE") != null) {
                    regAppAccount.setAppMphone(jsonAnalysis.getValue(regAccount.getInfo(), "PHONE"));

                }
                if (regAppAccount.getAppAuthority() != null && regAppAccount.getAppName() != null && regAppAccount.getAppBirth() != null && regAppAccount.getAppMail() != null && regAppAccount.getAppType() != null && regAppAccount.getAppMphone() != null) {
                    infoComplete = true;//判断info是否完整，在报文注册时有用
                }
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        this.ExecProto();
    }


    public void devCloseAccount() {
    }

    public void appCloseAccount() {
    }

    public void ExecProto() {
        logger.debug("进入账户管理协议处理-->");
        // 注册协议
        if (revPacket.getType() == ConstParam.TYPE_1) {
            logger.debug("注册账户报文-->");
            // dev
            if (revPacket.getSort() == ConstParam.SORT_2) {
                logger.debug("设备注册-->");
                devReg();
            }
            // app
            if (revPacket.getSort() == ConstParam.SORT_0) {
                logger.debug("用户注册-->");
                appReg();
            }
        }

        if (revPacket.getType() == ConstParam.TYPE_3) {
            logger.debug("修改账户报文-->");
            // dev
            if (revPacket.getSort() == ConstParam.SORT_2) {
                logger.debug("设备修改-->");
                devModify();
            }
            // app
            if (revPacket.getSort() == ConstParam.SORT_0) {
                logger.debug("用户修改-->");
                appModify();
            }
        }
        // 注销协议
        if (revPacket.getType() == ConstParam.TYPE_5) {
            logger.debug("账户注销报文-->");
            try {
                // 解码得到info中的phone
                BASE64Decoder decoder = new BASE64Decoder();
                String mphone = new String(decoder.decodeBuffer(regAccount.getInfo()));
                byte[] phoneBytes = mphone.getBytes();
                // dev
                if (revPacket.getSort() == ConstParam.SORT_2) {
                    //todo 已更改 需要测试
                    DeviceInf dev = deviceDao.selectDeviceBySid(revPacket.getSid());//deviceDao.findDevByID(revPacket.getSid());
                    // 存在dev且state！=0
                    if (dev != null && Integer.parseInt(dev.getState()) != 0) {
                        String password = dev.getPassword();
                        String phone = dev.getMphone();
                        byte[] passwordBytes = password.getBytes();
                        for (int i = 0; i < phoneBytes.length; i++) {
                            phoneBytes[i] = (byte) (phoneBytes[i] ^ passwordBytes[i]);
                            System.out.println(phoneBytes[i]);
                        }
                        String phonenum = new String(phoneBytes);
                        System.out.println("phonenum=" + phonenum);
                        if (phonenum.equals(phone)) {
                            // 记录到devlog表中
                            DeviceLog devLog = new DeviceLog();
                            devLog.setDeviceid(revPacket.getSid());
                            devLog.setDate(new Date());
                            String ip = ((InetSocketAddress) revPacket.getIoSession().getRemoteAddress()).getAddress()
                                    .getHostAddress();
                            int port = ((InetSocketAddress) revPacket.getIoSession().getRemoteAddress()).getPort();
                            devLog.setIpaddr(ip);
                            devLog.setPort(port);
                            //todo操作需要优化
                            devLog.setOperate(ConstParam.LOGIN_OPERATE_2);
                            devLogDao = (DeviceLogMapper) ApplicationContextHelper.getBean("deviceLogMapper");
                            devLogDao.insert(devLog);
                            // 置device_inf表中state=0
                            //todo 已更改 需要测试
                            deviceDao.changeStateToZeroById(revPacket.getSid());
                            // 删除全局数据中的节点
//                            DevNode devNode = (DevNode)userNode;//SysInfo.getInstance().getDevNodeById(revPacket.getSid())
                            SysInfo.getInstance().removeUserNode(userNode);
                            // 获取注销成功日期
                            offDate = new Date();
                            // 返回注销成功报文
                            byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3);
                            SendPkt(successPacket);
                            userNode.setLastPacketInfo(successPacket);
                        } else { // 电话不对 验证失败
                            byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
                            SendPkt(errorPacket);
                            userNode.setLastPacketInfo(errorPacket);
                        }
                    } else {
                        // dev == null不处理 state=0返回已注销
                        if (Integer.parseInt(dev.getState()) == 0) {
                            // 通过查找operate=-1和deviceid 两个条件一起查找
                            //todo
                            offDate = devLogDao.selectOffDateByIdAndOprate(revPacket.getSid(), ConstParam.LOGIN_OPERATE_2);
                            byte[] packet = PackPkt(ConstParam.SENT_PKT_TYPE_2);
                            SendPkt(packet);
                            userNode.setLastPacketInfo(packet);
                        }
                    }
                }
                // app
                if (revPacket.getSort() == ConstParam.SORT_0) {
                    //todo
                    UserInf app = userDao.selectUserBySid(revPacket.getSid());//userDao.findAppuserByID(revPacket.getSid());
                    // 存在dev且state！=0
                    if (app != null && Integer.parseInt(app.getState()) != 0) {
                        String password = app.getPassword();
                        String phone = app.getMphone();
                        byte[] passwordBytes = password.getBytes();
                        for (int i = 0; i < phoneBytes.length; i++) {
                            phoneBytes[i] = (byte) (phoneBytes[i] ^ passwordBytes[i]);
                        }
                        String phonenum = new String(phoneBytes);
                        System.out.println("phonenum=" + phonenum);
                        if (phonenum.equals(phone)) {
                            // 记录到userlog表中
                            UserLog userLog = new UserLog();
                            userLog.setUserid(revPacket.getSid());
                            userLog.setDate(new Date());
                            String ip = ((InetSocketAddress) revPacket.getIoSession().getRemoteAddress()).getAddress()
                                    .getHostAddress();
                            int port = ((InetSocketAddress) revPacket.getIoSession().getRemoteAddress()).getPort();
                            userLog.setIpaddr(ip);
                            userLog.setPort(port);
                            //todo oprate 需要更改
                            userLog.setOperate(ConstParam.LOGIN_OPERATE_2);
                            userLogDao.insert(userLog);
                            // 置device_inf表中state=0
                            //todo
                            userDao.changeStateToZeroById(revPacket.getSid());
                            // 删除全局数据中的节点
                            //AppNode appNode = (AppNode) SysInfo.getInstance().getAppNodeById(revPacket.getSid());
                            SysInfo.getInstance().removeUserNode(userNode);
                            // 获取注销成功日期
                            offDate = new Date();
                            // 返回注销成功报文
                            byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3);
                            SendPkt(successPacket);
                            userNode.setLastPacketInfo(successPacket);
                        } else { // 电话不对 验证失败
                            byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
                            SendPkt(errorPacket);
                            userNode.setLastPacketInfo(errorPacket);
                        }
                    } else {
                        // app == null不处理 state=0返回已注销
                        if (Integer.parseInt(app.getState()) == 0) {
                            // 通过查找operate=-1和deviceid 两个条件一起查找
                            //todo
                            offDate = userLogDao.selectOffDateByIdAndOprate(revPacket.getSid(), ConstParam.LOGIN_OPERATE_2);
                            byte[] packet = PackPkt(ConstParam.SENT_PKT_TYPE_2);
                            SendPkt(packet);
                            userNode.setLastPacketInfo(packet);
                        }
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }


    public byte[] PackPkt(int i) {
        // TODO Auto-generated method stub
        PacketMsg msg = new PacketMsg();
        msg.setCmd(ConstParam.CMD_2);
        // 不同的请求报文 返回的应答应答不一样
        //注册请求
        if (revPacket.getType() == ConstParam.TYPE_1) {
            msg.setType(ConstParam.TYPE_2); // type=2
        }
        //注销请求
        if (revPacket.getType() == ConstParam.TYPE_5) {
            msg.setType(ConstParam.TYPE_6);
        }
        // 账号修改
        if (revPacket.getType() == ConstParam.TYPE_3) {
            msg.setType(ConstParam.TYPE_4);
        }
        msg.setOpt(ConstParam.OPT_16);
        msg.setAck(revPacket.getSeq());
        String info;
        int ret;
        JSONObject data = new JSONObject();
        JSONObject dataChild = new JSONObject();
        switch (i) {
            case 1: // ret=-1
                if (revPacket.getType() == ConstParam.TYPE_1) {//ret=-1 表示账号申请失败，返回错误原因
                    if (errorPktState == ConstParam.ERROR_PKT_STATE_0) {
                        ret = -1;
                        info = "not exist in database";
                        dataChild.put("RET", ret);
                        dataChild.put("INFO", info);
                    }
                    if (errorPktState == ConstParam.ERROR_PKT_STATE_1) {
                        ret = -1;
                        info = "password is wrong";
                        dataChild.put("RET", ret);
                        dataChild.put("INFO", info);
                    }
                    if (errorPktState == ConstParam.ERROR_PKT_STATE_2) {
                        ret = -1;
                        info = "info is not complete";
                        dataChild.put("RET", ret);
                        dataChild.put("INFO", info);
                    }
                    if (errorPktState == ConstParam.ERROR_PKT_STATE_3) {
                        ret = -1;
                        info = "username is not right！";
                        dataChild.put("RET", ret);
                        dataChild.put("INFO", info);
                    }
                }

                if (revPacket.getType() == ConstParam.TYPE_5) {//注销账号应答
                    ret = -1;
                    info = "log off confirmate fail";
                    dataChild.put("RET", ret);
                    dataChild.put("INFO", info);
                }

                if (revPacket.getType() == ConstParam.TYPE_3) {//修改账号应答
                    if (errorPktState == ConstParam.ERROR_PKT_STATE_0) {
                        ret = -1;
                        info = "not exist in database";
                        dataChild.put("RET", ret);
                        dataChild.put("INFO", info);
                    }
                    if (errorPktState == ConstParam.ERROR_PKT_STATE_1) {
                        ret = -1;
                        info = "username is not right！";
                        dataChild.put("RET", ret);
                        dataChild.put("INFO", info);
                    }
                }
                break;

            case 2: // ret=1
                if (revPacket.getType() == ConstParam.TYPE_1) {//账号已经存在
                    ret = 1;
                    dataChild.put("RET", ret);
                    dataChild.put("INFO", "" + sid);
                }
                if (revPacket.getType() == ConstParam.TYPE_5) {//账号已经注销
                    ret = 1;
                    dataChild.put("RET", ret);
                    dataChild.put("INFO", offDate.getTime());
                }
                if (revPacket.getType() == ConstParam.TYPE_3) {//账号已经变更过
                    ret = 1;
                    dataChild.put("RET", ret);
                    dataChild.put("INFO", "" + sid);
                }
                break;

            case 3: // ret=0
                if (revPacket.getType() == ConstParam.TYPE_1) {   //注册成功
                    ret = 0;
                    dataChild.put("RET", ret);
                    dataChild.put("INFO", "" + sid);
                }
                if (revPacket.getType() == ConstParam.TYPE_5) {   //注销成功
                    ret = 0;
                    dataChild.put("RET", ret);
                    dataChild.put("INFO", offDate.getTime());
                }
                if (revPacket.getType() == ConstParam.TYPE_3) { // 通过变更
                    ret = 0;
                    dataChild.put("RET", ret);
                    dataChild.put("INFO", "" + sid);
                }
                break;

        }
        data.put("DATA", dataChild);
        msg.setData(data.toString());
        data.clear();
        dataChild.clear();
        return msg.createMessage(msg);
    }

    public void SendPkt(byte[] sendPacket) {
        // TODO Auto-generated method stub
        revPacket.getIoSession().write(IoBuffer.wrap(sendPacket));// 发送报文
    }

    public void devReg() {
        System.out.println("进入函数");
        if (regAccount.getInfo() == null) {
            System.out.println("info为null");
            //TODO
            DeviceInf deviceInf = deviceDao.selectDeviceByUserName(regAccount.getUser());//deviceDao.findDevByName(user);
            // 不存在该username
            if (deviceInf == null) {
                errorPktState = ConstParam.ERROR_PKT_STATE_0; // 标记发送第一种错误报文（数据库中不存在该记录）
                byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
                SendPkt(errorPacket);
            } else {
                sid = deviceInf.getDeviceid();
                if (!regAccount.getPassword().equals(deviceInf.getPassword())) {
                    errorPktState = ConstParam.ERROR_PKT_STATE_1; // 存在该记录,但是密码不正确
                    byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
                    SendPkt(errorPacket);
                } else {
                    byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_2);
                    SendPkt(successPacket);
                }
            }
        } else {
            System.out.println("info不为null");
            if (infoComplete) {
                System.out.println("信息完整");
                if (revPacket.getSort() == 2) {
                    System.out.println("bingo");
                    //TODO
                    DeviceInf deviceInf = deviceDao.selectDeviceByUserName(regAccount.getUser());//deviceDao.findDevByName(user);
                    System.out.println("bingo2");
                    if (deviceInf != null) {
                        sid = deviceInf.getDeviceid();
                        byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_2);
                        SendPkt(successPacket);
                    } else {
                        DeviceInf dev = new DeviceInf();
                        dev.setSerial(regDevAccount.getDevSerial());
                        dev.setCode(regDevAccount.getDevCode());
                        dev.setUsername(regAccount.getUser());
                        dev.setPassword(regAccount.getPassword());
                        dev.setState("1");// 0禁止 1激活
                        dev.setLongitude(regDevAccount.getDevLongitude());
                        dev.setLatitude(regDevAccount.getDevLatitude());
                        dev.setDate(new Date());
                        dev.setType(regDevAccount.getDevType());
                        dev.setMaxconlimit(regDevAccount.getDevMaxConLimit());
                        dev.setMphone(regDevAccount.getDevMphone());
                        sid = deviceDao.insert(dev);
                        byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3);
                        SendPkt(successPacket);
                    }
                }
            } else {
                System.out.println("信息不完整");
                errorPktState = ConstParam.ERROR_PKT_STATE_2;
                byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
                SendPkt(errorPacket);
            }
        }
    }

    public void appReg() {
        logger.debug(regAppAccount.toString());
        if (regAccount.getInfo() == null) {
            // 通过user查询数据库是否存在该用户
            //todo
            UserInf userInf = userDao.selectUserByUserName(regAccount.getUser());//userDao.findAppuserByName(user);
            // 不存在该username
            if (userInf == null) {
                errorPktState = ConstParam.ERROR_PKT_STATE_0; // 标记发送第一种错误报文（数据库中不存在该记录）
                byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
                SendPkt(errorPacket);
            } else {
                sid = userInf.getUserid();
                if (!regAccount.getPassword().equals(userInf.getPassword())) {
                    errorPktState = ConstParam.ERROR_PKT_STATE_1; // 存在该记录,但是密码不正确
                    byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
                    SendPkt(errorPacket);
                } else {
                    byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_2);
                    SendPkt(successPacket);
                }
            }
        } else {
            if (infoComplete) {
                //TODO
                logger.debug("注册信息完整-->");
                userDao = ApplicationContextHelper.getBean(UserInfMapper.class);
                UserInf userInf = userDao.selectUserByUserName(regAccount.getUser());//userDao.findAppuserByName(user);
                logger.info("查询数据库中是否用户账户是否重复-->");
                if (userInf != null) {
                    sid = userInf.getUserid();
                    byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_2);
                    SendPkt(successPacket);
                } else {
                    UserInf app = new UserInf();
                    app.setUsername(regAccount.getUser());
                    app.setPassword(regAccount.getPassword());
                    app.setSets("1");// 1添加关联不确认；2添加联系人不确认；4
                    // 禁止添加关联；8禁止添加联系人
                    app.setRegdate(new Date());
                    app.setAuthority(regAppAccount.getAppAuthority());
                    app.setState("1");// 0未激活 1激活使用
                    app.setName(regAppAccount.getAppName());
                    app.setBirth(regAppAccount.getAppBirth());
                    app.setSex(regAppAccount.getAppSex());
                    app.setType(regAppAccount.getAppType());
                    app.setMail(regAppAccount.getAppMail());
                    app.setMphone(regAppAccount.getAppMphone());
                    sid = userDao.insert(app);
                    byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3);
                    SendPkt(successPacket);
                }
            } else {
                errorPktState = ConstParam.ERROR_PKT_STATE_2;
                byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
                SendPkt(errorPacket);
            }
        }
    }

    public void appModify() {
        int same = 0;
        int change = 0;
        // 通过user查询数据库是否存在该用户
        //TODO 已更改 需要测试
        UserInf userInf = userDao.selectUserBySid(revPacket.getSid());//userDao.findAppuserByID(revPacket.getSid());
        // 不存在该用户
        if (userInf == null) {
            errorPktState = ConstParam.ERROR_PKT_STATE_0; // 标记发送第一种错误报文（数据库中不存在该记录）
            byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
            SendPkt(errorPacket);
            userNode.setLastPacketInfo(errorPacket);
        } else if (!userInf.getUsername().equals(regAccount.getUser())) {
            errorPktState = ConstParam.ERROR_PKT_STATE_1; // 标记发送第二种错误报文（用户名和数据库中的不匹配）
            byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
            SendPkt(errorPacket);
            userNode.setLastPacketInfo(errorPacket);
        } else {
            if (regAppAccount.getAppAuthority() != null) {
                if (userInf.getAuthority().equals(regAppAccount.getAppAuthority())) {
                    ++same;
                } else {
                    userInf.setAuthority(regAppAccount.getAppAuthority());
                    ++change;
                }
            }
            if (regAppAccount.getAppBirth() != null) {
                if (userInf.getBirth().equals(regAppAccount.getAppBirth())) {
                    ++same;
                } else {
                    userInf.setBirth(regAppAccount.getAppBirth());
                    ++change;
                }
            }
            if (regAppAccount.getAppMail() != null) {
                if (userInf.getMail().equals(regAppAccount.getAppMail())) {
                    ++same;
                } else {
                    userInf.setMail(regAppAccount.getAppMail());
                    ++change;
                }
                if (regAppAccount.getAppMphone() != null) {
                    if (userInf.getMphone().equals(regAppAccount.getAppMphone())) {
                        ++same;
                    } else {
                        userInf.setMphone(regAppAccount.getAppMphone());
                        ++change;
                    }
                }
            }
            if (regAppAccount.getAppName() != null) {
                if (userInf.getName().equals(regAppAccount.getAppName())) {
                    ++same;
                } else {
                    userInf.setName(regAppAccount.getAppName());
                    ++change;
                }
            }
            if (regAppAccount.getAppType() != null) {
                if (userInf.getType().equals(regAppAccount.getAppType())) {
                    ++same;
                } else {
                    userInf.setType(regAppAccount.getAppType());
                    ++change;
                }
            }
            if (regAppAccount.getAppSex() != null) {
                if (userInf.getSex() == regAppAccount.getAppSex()) {
                    ++same;
                } else {
                    userInf.setSex(regAppAccount.getAppSex());
                    ++change;
                }
            }
            if (regAccount.getPassword() != null) {
                if (userInf.getPassword().equals(regAccount.getPassword())) {
                    ++same;
                } else {
                    userInf.setPassword(regAccount.getPassword());
                    ++change;
                }
            }
            System.out.println("共有" + change + "个信息更改");
            if (change == 0 && same != 0) {// 返回RET=1，表明数据已经更新过
                sid = userInf.getUserid();
                byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_2);// 通过变更
                SendPkt(successPacket);
                userNode.setLastPacketInfo(successPacket);
            } else {
                //TODO
                userDao.updateUserInf(userInf);
                //sid = userDao.findAppuserByName(user).getUserID();
                byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3);// 通过变更
                SendPkt(successPacket);
                userNode.setLastPacketInfo(successPacket);
            }
        }
    }

    public void devModify() {
        //TODO
        DeviceInf deviceInf = deviceDao.selectDeviceBySid(revPacket.getSid());//deviceDao.findDevByID(revPacket.getSid());
        int same = 0;
        int change = 0;
        // 不存在该账号
        if (deviceInf == null) {
            errorPktState = ConstParam.ERROR_PKT_STATE_0; // 标记发送第一种错误报文（数据库中不存在该记录）
            byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
            SendPkt(errorPacket);
            userNode.setLastPacketInfo(errorPacket);
        } else if (!deviceInf.getUsername().equals(regAccount.getUser())) {
            errorPktState = ConstParam.ERROR_PKT_STATE_1; // 标记发送第二种错误报文（用户名和数据库中的不匹配）
            byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1);
            SendPkt(errorPacket);
            userNode.setLastPacketInfo(errorPacket);
        } else {

            if (regDevAccount.getDevSerial() != null) {
                if (deviceInf.getSerial().equals(regDevAccount.getDevSerial())) {
                    ++same;
                } else {
                    deviceInf.setSerial(regDevAccount.getDevSerial());
                    ++change;
                }
            }
            if (regDevAccount.getDevCode() != null) {
                if (deviceInf.getCode().equals(regDevAccount.getDevCode())) {
                    ++same;
                } else {
                    deviceInf.setCode(regDevAccount.getDevCode());
                    ++change;
                }
            }
            if (regDevAccount.getDevLongitude() != null) {
                if (deviceInf.getLongitude().equals(regDevAccount.getDevLongitude())) {
                    ++same;
                } else {
                    ++change;
                    deviceInf.setLongitude(regDevAccount.getDevLongitude());
                }

            }
            if (regDevAccount.getDevLatitude() != null) {
                if (deviceInf.getLatitude().equals(regDevAccount.getDevLatitude())) {
                    ++same;
                } else {
                    ++change;
                    deviceInf.setLatitude(regDevAccount.getDevLatitude());
                }

            }
            if (regDevAccount.getDevType() != null) {
                if (deviceInf.getType().equals(regDevAccount.getDevType())) {
                    ++same;
                } else {
                    ++change;
                    deviceInf.setType(regDevAccount.getDevType());
                }
            }
            if (regDevAccount.getDevMaxConLimit() != -1 && deviceInf.getMaxconlimit() != regDevAccount.getDevMaxConLimit()) {
                deviceInf.setMaxconlimit(regDevAccount.getDevMaxConLimit());
                ++change;
            } else {
                ++same;
            }
            if (regDevAccount.getDevMphone() != null) {
                if (deviceInf.getMphone().equals(regDevAccount.getDevMphone())) {
                    ++same;
                } else {
                    ++change;
                    deviceInf.setMphone(regDevAccount.getDevMphone());
                }
            }
            if (regAccount.getPassword() != null) {
                if (deviceInf.getPassword().equals(regAccount.getPassword())) {
                    ++same;
                } else {
                    ++change;
                    deviceInf.setPassword(regAccount.getPassword());
                }
                // deviceInf.setState("1");//密码已更改，需要密码验证
            }
            System.out.println("共有" + change + "个信息更改");
            if (change == 0 && same != 0) {
                sid = deviceInf.getDeviceid();
                byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_2);// 通过变更
                SendPkt(successPacket);
                userNode.setLastPacketInfo(successPacket);
            } else {
                //TODO
                deviceDao.updateDeviceInf(deviceInf);
                sid = deviceDao.selectDeviceByUserName(regAccount.getUser()).getDeviceid();
                byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3);// 通过变更
                SendPkt(successPacket);
                userNode.setLastPacketInfo(successPacket);
            }
        }
    }
}
