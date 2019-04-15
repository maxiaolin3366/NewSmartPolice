package cn.smartpolice.protocol;

/**
 * cmd=1 登录协议
 *
 * @author 马晓林
 */

import java.io.IOException;
import java.util.Date;
import java.util.Random;


import cn.smartpolice.dao.DeviceInfMapper;
import cn.smartpolice.dao.DeviceLogMapper;
import cn.smartpolice.dao.UserInfMapper;
import cn.smartpolice.dao.UserLogMapper;
import cn.smartpolice.entity.DeviceInf;
import cn.smartpolice.entity.DeviceLog;
import cn.smartpolice.entity.UserInf;
import cn.smartpolice.entity.UserLog;
import cn.smartpolice.tools.ApplicationContextHelper;
import org.apache.mina.core.buffer.IoBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.smartpolice.tools.JsonAnalysis;
import cn.smartpolice.workbean.AppNode;
import cn.smartpolice.workbean.DevNode;
import cn.smartpolice.workbean.PacketInfo;
import cn.smartpolice.workbean.SysInfo;
import cn.smartpolice.workbean.UserNode;
import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

public class ProtocolLogin extends ProtocolBase implements ConstParam {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    String snum; // 软件编号
    String sver;
    String user; // 用户账号
    String code; // 加密编码后的随机数
    int errorPktState; // 标记不同错误报文（一种是登陆请求信息不完整或错误(errorState=0)，一种是密码验证错误(errorState=1)）
    int random; // 随机数
    int uLink;
    int userNodeLink;
    UserNode userNode;
    private DeviceLogMapper deviceLogDao = ApplicationContextHelper.getBean(DeviceLogMapper.class);
    private UserLogMapper usersLogDao = ApplicationContextHelper.getBean(UserLogMapper.class);
    private UserInfMapper userDao = ApplicationContextHelper.getBean(UserInfMapper.class);
    private DeviceInfMapper deviceDao = ApplicationContextHelper.getBean(DeviceInfMapper.class);

    public void ParsePktProto(PacketInfo packetInfo) {

        super.revPacket = packetInfo;
        String data = packetInfo.getData();
        // 登录请求
        if (revPacket.getType() == ConstParam.TYPE_1) {
            snum = JsonAnalysis.getValue(data, "SNUM");
            sver = JsonAnalysis.getValue(data, "SVER");
            user = JsonAnalysis.getValue(data, "USER");
            if (JsonAnalysis.getValue(data, "LINK") != null) {
                userNodeLink = Integer.parseInt(JsonAnalysis.getValue(data, "LINK"));
            }
        }
        // 登录验证 登出验证只有user
        if (revPacket.getType() == ConstParam.TYPE_3) {
            code = JsonAnalysis.getValue(data, "CODE");
            user = JsonAnalysis.getValue(data, "USER");
        }
        if (revPacket.getType() == ConstParam.TYPE_5) {
            user = JsonAnalysis.getValue(data, "USER");
            if (JsonAnalysis.getValue(data, "LINK") != null) {
                userNodeLink = Integer.parseInt(JsonAnalysis.getValue(data, "LINK"));
            }
        }
        ExecProto();
    }

    public void ExecProto() {

        logger.debug("进入连接管理协议-->开始协议解析");
        // dev设备处理
        if (revPacket.getSort() == ConstParam.SORT_2) {
            // 从节点队列中获取节点 当第一次登陆不成功时 以后登录会存在节点
            userNode = SysInfo.getInstance().getDevNodeById(revPacket.getSid());
            uLink = userNode.getLink();
        }
        // App
        if (revPacket.getSort() == ConstParam.SORT_0) {
            userNode = SysInfo.getInstance().getAppNodeById(revPacket.getSid());
            uLink = userNode.getLink();
        }

        // 登录请求报文处理
        if (revPacket.getType() == ConstParam.TYPE_1) {
            // 当第一次登陆不成功时 以后登录会存在节点,所以在这儿将state设为1，不然后面收到登录请求报文时会直接返回错误报文
            // 通过节点状态判断节点登录状态

            if (userNode.getState() == ConstParam.LOGIN_STATE_0 || userNode.getState() == ConstParam.LOGIN_STATE_1) {
                logger.debug("用户或设备还未成功登陆-->");
                // 报文信息有错或报文中的用户名和数据库中的用户名不一致
                if (snum == null && sver == null && user.equals(userNode.getAccount())) { // 比较节点中account和报文中的user
                    logger.debug("报文有误-->");
                    if (revPacket.getSort() == ConstParam.SORT_2) {
                        DevNode devNode = (DevNode) userNode;
                        SysInfo.getInstance().removeUserNode(devNode); // 删除队列中的节点
                    }
                    if (revPacket.getSort() == ConstParam.SORT_0) {
                        AppNode appNode = (AppNode) userNode;
                        SysInfo.getInstance().removeUserNode(appNode); // 删除队列中的节点
                    }
                    errorPktState = ConstParam.ERROR_PKT_STATE_0; // 标记发送第一种错误报文
                    byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1); // 构造需要的信息不完整或登录帐号和user不相同的出错报文
                    userNode.setLastPacketInfo(errorPacket);
                    SendPkt(errorPacket); // 返回一个出错报文
                    return;
                } else {
                    // 如果系统配置文件中配置了不需要验证，直接返回成功报文
                    // dev
                   /* if (SysInfo.getSysCfgInfo().getState() == ConstParam.CHECK_STATE_0 && revPacket.getSort() == ConstParam.SORT_2) {
                        // 节点登录状态置为2 直接从0置为2
                        userNode.setState(ConstParam.LOGIN_STATE_2);
                        // 在用户登录信息表插入一条记录 构造一个userLog对象插入
                        DeviceLog devLog = new DeviceLog();
                        Date logindate = new Date();
                        devLog.setDeviceid(userNode.getId());
                        devLog.setDate(logindate);
                        devLog.setIpaddr(userNode.getIp());
                        devLog.setPort(userNode.getPort());
                        devLog.setOperate(ConstParam.LOGIN_OPERATE_1);
                        deviceLogDao.insert(devLog); // 在用户登录信息表插入
                        byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3); // 构造登陆成功的报文
                        userNode.setLastPacketInfo(successPacket);
                        SendPkt(successPacket);// 如果当前用户状态为2（已经登录成功）直接返回登录成功报文
                        return;
                    }
                    // app 同上
                    if (SysInfo.getSysCfgInfo().getState() == ConstParam.CHECK_STATE_0
                            && revPacket.getSort() == ConstParam.SORT_0) {
                        // 节点登录状态置为2 直接从0置为2
                        userNode.setState(ConstParam.LOGIN_STATE_2);
                        // 在用户登录信息表插入一条记录 构造一个userLog对象插入
                        UserLog userLog = new UserLog();
                        Date logindate = new Date();
                        userLog.setUserId(userNode.getId());
                        userLog.setDate(logindate);
                        userLog.setIpaddr(userNode.getIp());
                        userLog.setPort(userNode.getPort());
                        userLog.setOperate(ConstParam.LOGIN_OPERATE_1);
                        UserLogDao userLogDao = usersLogDao;
                        userLogDao.insertUserLogInf(userLog); // 在用户登录信息表插入
                        byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3); // 构造登陆成功的报文
                        SendPkt(successPacket);// 如果当前用户状态为2（已经登录成功）直接返回登录成功报文
                        userNode.setLastPacketInfo(successPacket);
                        return;
                    }*/
                    // 如果系统配置文件中配置了需要验证，返回验证请求报文
//                    if (SysInfo.getSysCfgInfo().getState() == ConstParam.CHECK_STATE_1) {
                    // 随机数置于登录时间域
                    Random rando = new Random();
                    random = rando.nextInt(99999) % 90000 + 10000; // 产生一个随机数
                    userNode.setLoginDate(random);
                    userNode.setState(ConstParam.LOGIN_STATE_1); // 将用户状态置为1
                    // 更新后的devNode要放入全局队列中
                    if (revPacket.getSort() == ConstParam.SORT_2) {
                        DevNode devNode = (DevNode) userNode;
                        SysInfo.getInstance().addUserNode(devNode);
                    }
                    if (revPacket.getSort() == ConstParam.SORT_0) {
                        AppNode appNode = (AppNode) userNode;
                        SysInfo.getInstance().addUserNode(appNode);
                    }
                    byte[] checkPacket = PackPkt(ConstParam.SENT_PKT_TYPE_2); // 构造让对方发送验证请求报文de报文
                    logger.debug("发送请求验证报文-->");
                    userNode.setLastPacketInfo(checkPacket);
                    SendPkt(checkPacket); // 对方发送验证请求报文
                    return;
                }

            }
            // 节点掉线时，节点发登陆请求时，队列中的节点状态state=2时直接返回登录成功
            if (userNode.getState() == ConstParam.LOGIN_STATE_2 && revPacket.getSort() == ConstParam.SORT_2 && userNodeLink != 0) {
                if (userNodeLink == userNode.getLink()) {
                    logger.debug("设备已成功登陆，直接返回登陆成功报文-->");
                    // 在设备登录信息表插入一条记录 构造一个userLog对象插入
                    DeviceLog devLog = new DeviceLog();
                    Date logindate = new Date();
                    devLog.setDeviceid(userNode.getId());
                    devLog.setDate(logindate);
                    devLog.setIpaddr(userNode.getIp());
                    devLog.setPort(userNode.getPort());
                    devLog.setOperate(ConstParam.LOGIN_OPERATE_1);
                    deviceLogDao.insert(devLog); // 在设备登录信息表插入
                    byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3); // 构造登陆成功的报文
                    SendPkt(successPacket);// 如果当前用户状态为2（已经登录成功）直接返回登录成功报文
                    userNode.setLastPacketInfo(successPacket);
                    return;
                }
            }
            if (userNode.getState() == ConstParam.LOGIN_STATE_2 && revPacket.getSort() == ConstParam.SORT_0 && userNodeLink != 0) {
                if (userNodeLink == userNode.getLink()) {
                    logger.debug("用户已成功登陆，直接返回登陆成功报文-->");
                    // 在用户登录信息表插入一条记录 构造一个userLog对象插入
                    UserLog userLog = new UserLog();
                    Date logindate = new Date();
                    userLog.setUserid(userNode.getId());
                    userLog.setDate(logindate);
                    userLog.setIpaddr(userNode.getIp());
                    userLog.setPort(userNode.getPort());
                    userLog.setOperate(ConstParam.LOGIN_OPERATE_1);
                    usersLogDao.insert(userLog); // 在用户登录信息表插入
                    byte[] successPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3); // 构造登陆成功的报文
                    userNode.setLastPacketInfo(successPacket);
                    SendPkt(successPacket);// 如果当前用户状态为2（已经登录成功）直接返回登录成功报文
                    return;
                }
            }
        }

        // 验证请求报文
        if (revPacket.getType() == ConstParam.TYPE_3) {
            if (userNode.getState() == ConstParam.LOGIN_STATE_0 || userNode.getState() == ConstParam.LOGIN_STATE_2) { // 直接出错，返回出错报文
                logger.debug("登陆验证请求状态码不正确，返回验证失败报文-->");
                byte[] errorPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1); // 构造验证失败应答报文
                userNode.setLastPacketInfo(errorPacket);
                SendPkt(errorPacket);
                return;
            }
            if (userNode.getState() == ConstParam.LOGIN_STATE_1) {
                logger.debug("验证用户名-->");
                if (user.equals(userNode.getAccount())) {
                    try {

                        BASE64Decoder decoder = new BASE64Decoder();
                        String otherCode = new String(decoder.decodeBuffer(code)); // base64解码
                        logger.debug("将秘钥进行base64解码，得到字符串-->" + otherCode);
                        byte[] password;
                        if (revPacket.getSort() == ConstParam.SORT_2) { // dev
                            logger.debug("在数据库中查找设备信息-->");
                            DeviceInf deviceInf = deviceDao.selectDeviceBySid(revPacket.getSid());
                            password = deviceInf.getPassword().getBytes(); // 秘钥
                        } else { // app
                            logger.debug("在数据库中查找用户信息-->");
                            UserInf userInf = userDao.selectUserBySid(revPacket.getSid());
                            password = userInf.getPassword().getBytes();
                        }
                        // 将随机数加密
                        logger.debug("得到随机数字节数组-->");
                        byte[] passs = String.valueOf(userNode.getLoginDate()).getBytes();// 随机数变为字符串再得到byte数组
                        byte[] rondByte;
                        // 异或加密
                        logger.debug("将随机数字节数组与用户密码进行异或加密-->");
                        if (password.length <= passs.length) {
                            rondByte = passs;
                            int j = 0;
                            for (int i = 0; i < passs.length; i++) {
                                rondByte[i] = (byte) (passs[i] ^ password[j++]);
                                if (j == password.length) {
                                    j = 0;
                                }
                            }
                        } else {
                            rondByte = password;
                            int j = 0;
                            for (int i = 0; i < password.length; i++) {
                                rondByte[i] = (byte) (passs[j++] ^ password[i]);
                                if (j == passs.length) {
                                    j = 0;
                                }
                            }
                        }

                        String ron = new String(rondByte);
                        logger.debug("加密后的字符串-->" + ron);
                        if (ron.equals(otherCode)) {
                            logger.debug("将解码的秘钥与加密后的字符串比对正确，用户验证成功-->");
                            long loginDate = System.currentTimeMillis() / 1000;
                            userNode.setLoginDate(loginDate); // 置登录时间为当前时间
                            userNode.setState(2); // 将用户状态置2
                            // app
                            if (revPacket.getSort() == ConstParam.SORT_0) {
                                System.out.println(revPacket.getSort());
                                AppNode appNode = (AppNode) userNode;
                                // 将更新后的devnode更新到全局数据队列中
                                SysInfo.getInstance().addUserNode(appNode);
                                // 在用户登录信息表插入一条记录 构造一个userLog对象插入
                                UserLog userLog = new UserLog();
                                Date logindate = new Date();
                                userLog.setUserid(userNode.getId());
                                userLog.setDate(logindate);
                                userLog.setIpaddr(userNode.getIp());
                                userLog.setPort(userNode.getPort());
                                userLog.setOperate(ConstParam.LOGIN_OPERATE_1);
                                logger.debug("用户登陆成功，在日志表中写入记录，返回登陆成功报文-->");
                                usersLogDao.insert(userLog); // 在用户登录信息表插入
                                byte[] checkSuccessPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3); // 构造验证成功应答报文
                                userNode.setLastPacketInfo(checkSuccessPacket);
                                SendPkt(checkSuccessPacket);
                                return;
                            }
                            // dev
                            if (revPacket.getSort() == ConstParam.SORT_2) {
                                DevNode devNode = (DevNode) userNode;
                                SysInfo.getInstance().addUserNode(devNode);
                                // 在用户登录信息表插入一条记录 构造一个userLog对象插入
                                DeviceLog devLog = new DeviceLog();
                                Date logindate = new Date();
                                devLog.setDeviceid(userNode.getId());
                                devLog.setDate(logindate);
                                devLog.setIpaddr(userNode.getIp());
                                devLog.setPort(userNode.getPort());
                                devLog.setOperate(ConstParam.LOGIN_OPERATE_1);
                                logger.debug("设备登陆成功，在日志表中写入记录，返回登陆成功报文-->");
                                deviceLogDao.insert(devLog); // 在用户登录信息表插入
                                byte[] checkSuccessPacket = PackPkt(ConstParam.SENT_PKT_TYPE_3); // 构造验证成功应答报文
                                userNode.setLastPacketInfo(checkSuccessPacket);
                                SendPkt(checkSuccessPacket);
                                return;
                            }

                        } else {
                            // 如果验证失败 删除节点
                            logger.debug("密码验证失败，返回错误报文-->");
                            if (revPacket.getSort() == ConstParam.SORT_2) {
                                DevNode devNode = (DevNode) userNode;
                                SysInfo.getInstance().removeUserNode(devNode); // 删除队列中的节点
                            }
                            if (revPacket.getSort() == ConstParam.SORT_0) {
                                AppNode appNode = (AppNode) userNode;
                                SysInfo.getInstance().removeUserNode(appNode);
                            }
                            errorPktState = ConstParam.ERROR_PKT_STATE_1; // 发送验证失败的报文
                            byte[] checkFailPacket = PackPkt(ConstParam.SENT_PKT_TYPE_1); // 构造验证失败应答报文
                            userNode.setLastPacketInfo(checkFailPacket);
                            SendPkt(checkFailPacket);
                            return;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // 登出报文
        if (revPacket.getType() == ConstParam.TYPE_5) {
            logger.debug("转到登出报文-->");
            if (user.equals(userNode.getAccount()) && userNodeLink != 0) {
                logger.debug("用户名检查正确。LINK不为空-->");
                if (userNodeLink == userNode.getLink()) {
                    logger.debug("LINK比对正确-->");
                    if (revPacket.getSort() == ConstParam.SORT_2) {
                        SysInfo.getInstance().removeUserNode(userNode);
                        logger.debug("登出信息正确，删除设备节点-->");
                        DeviceLog devLog = new DeviceLog();
                        devLog.setDeviceid(userNode.getId());
                        devLog.setDate(new Date());
                        devLog.setIpaddr(userNode.getIp());
                        devLog.setPort(userNode.getPort());
                        devLog.setOperate(ConstParam.LOGIN_OPERATE_0);
                        deviceLogDao.insert(devLog);
                    } else if (revPacket.getSort() == ConstParam.SORT_0) {
                        SysInfo.getInstance().removeUserNode(userNode);
                        logger.debug("登出信息正确，删除用户节点-->");
                        UserLog userLog = new UserLog();
                        Date logindate = new Date();
                        userLog.setUserid(userNode.getId());
                        userLog.setDate(logindate);
                        userLog.setIpaddr(userNode.getIp());
                        userLog.setPort(userNode.getPort());
                        userLog.setOperate(ConstParam.LOGIN_OPERATE_0);
                        usersLogDao.insert(userLog); // 在用户登录信息表插入
                    } else {
                        logger.debug("登出类型检查不正确，不做任何处理-->");
                    }
                } else {
                    logger.debug("服务器存在的LINK与用户发送的不一致，不做处理-->");
                }
            } else {
                logger.debug("用户名检查不正确或LINK==0，不做任何处理-->");
            }
        }
        // 保活报文
        if (revPacket.getType() == ConstParam.TYPE_6) {
            logger.debug("保活报文-->");
            if (userNode != null) {
                // 更新接收到报文的时间
                userNode.setRevPktDate(new Date());
                if (revPacket.getType() == ConstParam.SORT_2) { // dev
                    DevNode devNode = (DevNode) userNode;
                    SysInfo.getInstance().addUserNode(devNode);
                }
                if (revPacket.getType() == ConstParam.SORT_0) { // app
                    AppNode appNode = (AppNode) userNode;
                    SysInfo.getInstance().addUserNode(appNode);
                }
                byte[] keepAlivePkt = PackPkt(ConstParam.SENT_PKT_TYPE_4);
                userNode.setLastPacketInfo(keepAlivePkt);
                SendPkt(keepAlivePkt);
                return;
            }
        }
    }

    public byte[] PackPkt(int i) {
        PacketMsg msg = new PacketMsg();
        msg.setAck(revPacket.getSeq());
        msg.setCmd(ConstParam.CMD_1);
        msg.setSid(ConstParam.SERVER_ID);
        if (revPacket.getType() == ConstParam.TYPE_1) {
            msg.setType(ConstParam.TYPE_2);
        }
        if (revPacket.getType() == ConstParam.TYPE_3) {
            msg.setType(ConstParam.TYPE_4);
        }
        if (revPacket.getType() == ConstParam.TYPE_6) {
            msg.setType(ConstParam.TYPE_7);
        }
        msg.setOpt(ConstParam.OPT_16);// opt=16 表示此报文是应答报文，确认号有效；
        JSONObject data = new JSONObject();
        JSONObject dataChild = new JSONObject();

        switch (i) {
            case 1: // 需要的信息不完整或登录帐号和user不相同时 返回的出错报文，密码验证失败时 返回错误报文
                if (errorPktState == ConstParam.ERROR_PKT_STATE_0) {
                    String s = "需要的信息不完整或登录帐号和user不相同";
                    dataChild.put("RET", -1);
                    dataChild.put("INFO", s);
                }
                if (errorPktState == ConstParam.ERROR_PKT_STATE_1) {
                    String s = "状态错误或密码不正确";
                    dataChild.put("RET", -1);
                    dataChild.put("INFO", s);
                }
                break;
            case 2: // 构造让对方发送验证请求报文de报文
                dataChild.put("RET", 1);
                dataChild.put("INFO", "" + random);
                break;
            case 3: // 通过验证后返回的登录成功报文 ， 请求登录时节点状态state=2时或系统文件配置不需要验证时返回的登录成功报文
                dataChild.put("RET", 0);
                dataChild.put("LINK", uLink);
                dataChild.put("INFO", "" + revPacket.getSid());
                break;
            case 4:
                logger.debug("case4保活应答报文没内容-->");
                break;
        }
        data.put("DATA", dataChild);
        msg.setData(data.toString());
        data.clear();
        dataChild.clear();
        return msg.createMessage(msg);
    }

    public void SendPkt(byte[] sendPacket) {
        revPacket.getIoSession().write(IoBuffer.wrap(sendPacket));// 发送报文
    }
}
