package cn.smartpolice.protocol;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Random;

import cn.smartpolice.dao.DeviceInfMapper;
import cn.smartpolice.dao.DeviceLogMapper;
import cn.smartpolice.dao.UserInfMapper;
import cn.smartpolice.dao.UserLogMapper;
import cn.smartpolice.entity.DeviceInf;
import cn.smartpolice.entity.UserInf;
import cn.smartpolice.tools.ApplicationContextHelper;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import cn.smartpolice.tools.JsonAnalysis;
import cn.smartpolice.workbean.AppNode;
import cn.smartpolice.workbean.DevNode;
import cn.smartpolice.workbean.PacketInfo;
import cn.smartpolice.workbean.SysInfo;
import cn.smartpolice.workbean.UserNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtocolProc {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    long count = 0; //统计系统收到的报文数
    UserNode userNode = null;
    private PacketInfo packetInfo = new PacketInfo();
    private DeviceInfMapper deviceDao;
    private DeviceLogMapper devLogDao;
    private UserInfMapper userDao;
    private UserLogMapper userLogDao;


    public void RecvPktProc(IoSession ios, byte[] message) throws IOException {
        logger.debug("进入协议解析类-->");
        deviceDao = ApplicationContextHelper.getBean(DeviceInfMapper.class);
        devLogDao = ApplicationContextHelper.getBean(DeviceLogMapper.class);
        userDao = ApplicationContextHelper.getBean(UserInfMapper.class);
        userLogDao = ApplicationContextHelper.getBean(UserLogMapper.class);

        SysInfo.getSysStatInfo().setReceicvenum(++count);
        packetInfo.setIoSession(ios);

        if (ParsePktHead(message) == true) {
            logger.debug("协议解析成功-->" + packetInfo.toString());
            if (CheckPktValid() == true) {
                // 进入具体协议处理
                logger.debug("协议检查无误，进入具体协议解析类-->");
                SysInfo.getProtocolBases()[packetInfo.getCmd()].ParsePktProto(packetInfo);
            } else {
                ios.closeNow();
                logger.debug("协议检查失败，本次报文不做处理-->");
            }
        } else {
            ios.closeNow();
            logger.debug("协议格式不正确，解析失败，不做处理-->");
        }
    }

    public Boolean ParsePktHead(byte[] message) throws IOException {
        ByteArrayInputStream ips = new ByteArrayInputStream(message);
        DataInputStream dis = new DataInputStream(ips);
        logger.debug("解包开始-->");
        if (message.length >= ConstParam.MASSAGE_LEN) {
            packetInfo.setMessage(message); // 为报文信息赋值
            packetInfo.setDate(new Date());
            packetInfo.setLength(message.length);// 报文长度

            byte[] znafBytes = new byte[ConstParam.ZNAF];
            for (int i = 0; i < znafBytes.length; i++)
                znafBytes[i] = dis.readByte();
            JsonAnalysis jsonAnalysis = new JsonAnalysis();
            String znaf = new String(znafBytes);

            if (znaf.equals("ZNAF")) {// 包含“ZNAF”时解包
                packetInfo.setCmd(dis.readByte());
                packetInfo.setType(dis.readByte());
                packetInfo.setOpt(dis.readByte());
                packetInfo.setSort(dis.readByte());

                if (packetInfo.getCmd() <= ConstParam.MAX_CMD) {// cmd小于13才解包

                    packetInfo.setSid(dis.readInt());
                    packetInfo.setSeq(dis.readInt());
                    packetInfo.setAck(dis.readInt());

                    // 非注册报文是否sid>0
                    if ((packetInfo.getCmd() == ConstParam.CMD_2 && packetInfo.getType() == ConstParam.TYPE_1) || packetInfo.getSid() > 0) {
                        // 根据opt，解析首部选项
                        StringBuffer buffer = new StringBuffer();
                        for (int i = 20; i < message.length; i++) {
                            buffer.append((char) message[i]);
                        }
                        String datas = buffer.toString();
                        int datapos = datas.indexOf("{\"DATA\"", 20) + (ConstParam.MASSAGE_LEN + 1);
                        packetInfo.setDatapos(datapos);// 数据域的起始位置
                        byte opt = packetInfo.getOpt();
                        if ((opt & 0x01) != 0) { //
                            String hopt1 = jsonAnalysis.getValue(datas, "HOPT");
                            if (hopt1 != null) {
                                String did = jsonAnalysis.getValue(hopt1, "DID");
                                packetInfo.setDid(Integer.parseInt(did));
                            }
                        }
                        if ((opt & 0x02) != 0) {
                            String hopt2 = jsonAnalysis.getValue(datas, "HOPT");
                            if (hopt2 != null) {
                                String keyseq = jsonAnalysis.getValue(hopt2, "KEYSEQ");
                                packetInfo.setKeyseq(Integer.parseInt(keyseq));
                            }
                        }
                        if ((opt & 0x04) != 0) {
                            String hopt3 = jsonAnalysis.getValue(datas, "HOPT");
                            if (hopt3 != null) {
                                String sip = jsonAnalysis.getValue(hopt3, "SIP");
                                String sport = jsonAnalysis.getValue(hopt3, "SPORT");
                                packetInfo.setSip(sip);
                                packetInfo.setSport(Integer.parseInt(sport));
                            }
                        }
                        if ((opt & 0x08) != 0) {

                        }
                        if ((opt & 0x16) != 0) {

                        }
                        if ((opt & 0x32) != 0) {

                        }
                        int len = message.length - packetInfo.getDatapos();
                        byte[] copy = new byte[len];
                        System.arraycopy(message, packetInfo.getDatapos(), copy, 0, len);
                        String datass;
                        //将收到的DATA域进行UTF-8编码
                        datass = new String(copy, StandardCharsets.UTF_8);
                        String data = jsonAnalysis.getValue(datass, "DATA");
                        packetInfo.setData(data);
                        return true;
                    } else
                        logger.debug("出错：非注册报文sid<0-->");
                    return false;
                } else
                    logger.debug("出错：cmd>12-->");
                return false;
            } else
                logger.debug("出错：报文头部不包含ZNAF-->");
            return false;
        } else
            logger.debug("出错：报文长度小于20字节-->");
        return false;
    }

    public Boolean CheckPktValid() {

        // 注册请求
        if (packetInfo.getCmd() == ConstParam.CMD_2 && packetInfo.getType() == ConstParam.TYPE_1) {
            logger.debug("该请求为-->注册请求");
            return true;
        }
        // 联通测试报文
        if (packetInfo.getCmd() == ConstParam.CMD_0 && packetInfo.getType() == ConstParam.TYPE_1
                && packetInfo.getOpt() == ConstParam.OPT_8) {
            logger.debug("该请求为-->联通测试");
            return true;
        }
        if (packetInfo.getCmd() == ConstParam.CMD_11 && packetInfo.getType() == ConstParam.TYPE_1
                && packetInfo.getOpt() == ConstParam.OPT_8) {
            logger.debug("该请求为-->升级查询");
            return true;
        }


        // 通过报文sort判断是dev还是app
        if (packetInfo.getSort() == ConstParam.SORT_2) {
            userNode = SysInfo.getInstance().getDevNodeById(packetInfo.getSid());
            logger.debug("该请求为-->前端设备");
        }
        if (packetInfo.getSort() == ConstParam.SORT_0) {
            userNode = SysInfo.getInstance().getAppNodeById(packetInfo.getSid());
            logger.debug("该请求为-->app用户");
        }

        if (userNode == null) {
            logger.debug("没有节点-->");
            if (packetInfo.getCmd() == ConstParam.CMD_1 && packetInfo.getType() == ConstParam.TYPE_1) {
                // 如果是dev登陆则创建新的dev节点
                logger.debug("登陆请求-->");
                if (packetInfo.getSort() == ConstParam.SORT_2) {
                    logger.debug("设备登陆请求-->");
                    DeviceInf devinf = deviceDao.selectDeviceBySid(packetInfo.getSid());
                    if (devinf != null) {
                        logger.debug("该设备已注册-->");
                        String ip = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getAddress()
                                .getHostAddress();
                        int port = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getPort();
                        DevNode devNode = new DevNode(); // 创建节点
                        Random rando = new Random();
                        int random = rando.nextInt(999999) % 900000 + 100000; // 产生6位随机数
                        devNode.setLink(random);
                        devNode.setIp(ip);
                        devNode.setPort(port);
                        devNode.setAccount(devinf.getUsername());
                        devNode.setId(devinf.getDeviceid());
                        devNode.setRevPktDate(new Date());
                        devNode.setIoSession(packetInfo.getIoSession());
                        devNode.setRevPktId(packetInfo.getSeq());
                        // 刚创建的节点的登录状态置0，表示还未验证
                        devNode.setState(ConstParam.LOGIN_STATE_0);
                        // 将节点信息添加到报文 仅仅为了在ProtocolLogin中取获取节点id (
                        packetInfo.setDevNode(devNode);
                        // 将节点添加到队列 在登录处理中从全局队列中取
                        SysInfo.getInstance().addUserNode(devNode);
                        logger.debug("创建节点-->");
                        logger.debug(devNode.toString());
                        return true;
                    } else
                        return false;
                } else if (packetInfo.getSort() == ConstParam.SORT_0) {
                    logger.debug("用户登陆-->");
                    UserInf appInf = userDao.selectUserBySid(packetInfo.getSid());
                    if (appInf != null) {
                        logger.debug("该用户已注册-->");
                        String ip = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getAddress()
                                .getHostAddress();
                        int port = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getPort();
                        AppNode appNode = new AppNode(); // 创建节点
                        Random rando = new Random();
                        int random = rando.nextInt(99999) % 90000 + 10000; // 产生??????5位随机数
                        appNode.setLink(random);
                        appNode.setIp(ip);
                        appNode.setPort(port);
                        appNode.setAccount(appInf.getUsername());
                        appNode.setId(appInf.getUserid());
                        appNode.setRevPktDate(new Date());
                        appNode.setRevPktId(packetInfo.getSeq());
                        appNode.setIoSession(packetInfo.getIoSession());
                        appNode.setState(ConstParam.LOGIN_STATE_0);
                        packetInfo.setAppNode(appNode);
                        SysInfo.getInstance().addUserNode(appNode); // 将节点添加到队列
                        logger.debug("创建节点-->");
                        logger.debug(appNode.toString());
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    logger.debug("不支持其他客户类型-->");
                    return false;
                }
            } else {
                logger.debug("未登录时无节点，其他操作无法进行-->");
                return false;
            }
        }

        // 1.请求验证（登录请求后返回请求验证的报文）2.登录请求（还没来得及删除全局队列中的节点），3.保活报文从这儿进
        else {
            logger.debug("存在节点-->");
            if (userNode.getState() == ConstParam.LOGIN_STATE_2) { //是成功登陆的节点
                logger.debug("该节点已经登陆-->");
                JsonAnalysis jsonAnalysis = new JsonAnalysis();
                if (jsonAnalysis.getValue(packetInfo.getData(), "LINK") != null) {// 如果配置的有LINK，则与节点中的LINK对比，是否相同
                    logger.debug("LINK不为空-->");
                    int link = Integer.parseInt(jsonAnalysis.getValue(packetInfo.getData(), "LINK"));
                    if (userNode.getLink() == link) {
                        logger.debug("LINK与服务器比对正确");
                        return updateUserNode();
                    } else {
                        logger.debug("LINK与服务器中值不一致-->");
                        return false;
                    }
                } else {
                    return updateUserNode(); //未配置安全码LINK 直接更新节点
                }
            } else { // 未登录节点
                logger.debug("节点未登陆-->");
                if (!updateUserNode()) {
                    return false;
                } // 更新节点信息
                if (packetInfo.getCmd() == ConstParam.CMD_1 && packetInfo.getType() == ConstParam.TYPE_1) {
                    logger.debug("更新节点信息，是登陆请求-->");
                    return true;
                } else if (packetInfo.getCmd() == ConstParam.CMD_1 && packetInfo.getType() == ConstParam.TYPE_3) {
                    logger.debug("是登陆请求验证报文-->");
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean updateUserNode() {
        // 检查源IP和端口，看是否改变
        logger.debug("更新节点信息-->");
        String ip = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getAddress()
                .getHostAddress();
        int port = ((InetSocketAddress) packetInfo.getIoSession().getRemoteAddress()).getPort();
        if (!userNode.getIp().equals(ip) || userNode.getPort() != port) {
            logger.debug("客户端ip或端口已经改变-->");
            userNode.setIp(ip);
            userNode.setPort(port);
            userNode.setIoSession(packetInfo.getIoSession());
        }
        userNode.setRevPktDate(new Date()); // 记录最近接收报文时间
        if (userNode instanceof DevNode) {
            DevNode devNode = (DevNode) userNode;
            packetInfo.setDevNode(devNode);
        } else {
            AppNode appNode = (AppNode) userNode;
            packetInfo.setAppNode(appNode);
        }
        if (userNode.getRevPktId() == packetInfo.getSeq()) {//报文重复，返回上缓存报文
            logger.debug("报文接收重复，返回上一次报文-->");
            packetInfo.getIoSession().write(IoBuffer.wrap(userNode.getLastPacketInfo()));
            return false;
        }
        userNode.setRevPktId(packetInfo.getSeq());
        return true;

    }
}
