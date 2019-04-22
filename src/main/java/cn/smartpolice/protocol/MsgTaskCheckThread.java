package cn.smartpolice.protocol;

import java.util.Date;
import java.util.List;


import cn.smartpolice.dao.*;
import cn.smartpolice.entity.*;
import cn.smartpolice.tools.ApplicationContextHelper;
import org.apache.mina.core.buffer.IoBuffer;

import cn.smartpolice.tools.JsonAnalysis;
import cn.smartpolice.workbean.MsgTask;
import cn.smartpolice.workbean.SysInfo;
import cn.smartpolice.workbean.UserNode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息推送检查线程 检查消息推送任务队列 若队列不为null则根据任务node信息，在消息发送记录表中添加记录，并在此线程中给在线的节点发送未读消息通知
 *
 * @author maxiaolin
 */
public class MsgTaskCheckThread implements Runnable {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    int sign;
    int messageid;

    private MsgRecvMapper msgRecvDao = ApplicationContextHelper.getBean(MsgRecvMapper.class);
    private MsgAlarmMapper msgAlarmDao = ApplicationContextHelper.getBean(MsgAlarmMapper.class);
    private MsgChatMapper msgChatDao = ApplicationContextHelper.getBean(MsgChatMapper.class);
    private MsgNoticeMapper msgNoticeDao = ApplicationContextHelper.getBean(MsgNoticeMapper.class);
    private UserInfMapper userDao = ApplicationContextHelper.getBean(UserInfMapper.class);
    private RelateInfMapper relateDao = ApplicationContextHelper.getBean(RelateInfMapper.class);

    public void run() {

        while (!SysInfo.getMsgTaskQueue().isEmpty()) {
            logger.debug("消息线程开始-->");
            MsgTask msgTask = SysInfo.getMsgTaskQueue().get(0);
            JsonAnalysis jsonAnalysis = new JsonAnalysis();
            try {

                if (msgTask.getmType() == 1) {
                    MsgAlarm alarm = new MsgAlarm();
                    alarm.setDeviceid(msgTask.getSendUserID());
                    alarm.setTime(new Date(msgTask.getmDate()));
                    String sort = JsonAnalysis.getValue(msgTask.getContent(), "SORT");
                    if (sort != null) {
                        alarm.setSort(Integer.parseInt(sort));
                    }
                    String level = JsonAnalysis.getValue(msgTask.getContent(), "LEVEL");
                    if (level != null) {
                        alarm.setLevel(Integer.parseInt(level));// 级别
                    }
                    String attach = JsonAnalysis.getValue(msgTask.getContent(), "ATTACH");
                    if (attach != null) {
                        alarm.setUrl(attach);// 得到URL
                    }
                    // 存入报警消息表,并且返回消息编号
                    msgAlarmDao.insert(alarm);
                    messageid = alarm.getAlarmid();
                    // 将消息通知推送给前端设备关联人
                    if (msgTask.getRevUserID() == 1) {
                        // 查询关联关系表得到所有关联人id
                        List<RelateInf> list = relateDao.findUserIdByDeviceId(msgTask.getSendUserID());

                        for (int i = 0; i < list.size(); i++) {
                            Integer recvuserid = list.get(i).getUserid();
                            // 存入消息接收记录表，返回SIGN
                            MsgRecv msgRecv = new MsgRecv();
                            msgRecv.setMessageid(messageid);
                            msgRecv.setSenduserid(msgTask.getSendUserID());
                            msgRecv.setRecvuserid(recvuserid);
                            msgRecv.setMsgtype("1");//
                            msgRecv.setState("0"); // 标记为未读
                            msgRecv.setRecvtype(1);
                            msgRecv.setRecvtime(new Date(msgTask.getmDate()));
                            msgRecvDao.insert(msgRecv);
                            sign = msgRecv.getRecvid();
                            UserNode userNode = SysInfo.getInstance().getAppNodeById(recvuserid);
                            if (userNode != null) {
                                byte[] packPkt = PackPkt(msgTask, alarm, userNode);
                                userNode.getIoSession().write(IoBuffer.wrap(packPkt));
                                userNode.setLastPacketInfo(packPkt);// 更新缓存
                            }
                        }
                        SysInfo.getInstance().removeMsgTask(msgTask);
                    } else {
                        SysInfo.getInstance().removeMsgTask(msgTask);
                        logger.debug("接收者id不正确，已删除节点-->");
                    }
                }
                // type==2为聊天消息
                else if (msgTask.getmType() == 2) {
                    if (msgTask.getRevUserID() > 10000) {
                        MsgChat chat = new MsgChat();
                        String msg = JsonAnalysis.getValue(msgTask.getContent(), "MSG");
                        String type = JsonAnalysis.getValue(msgTask.getContent(), "TYPE");// 字形
                        String color = JsonAnalysis.getValue(msgTask.getContent(), "COLOR");
                        chat.setColor(color);
                        chat.setMsg(msg);
                        chat.setType(type);
                        chat.setSendid(msgTask.getSendUserID());
                        chat.setSendtime(new Date(msgTask.getmDate()));
                        chat.setRecvid(msgTask.getRevUserID());
                        // 插入聊天消息表,返回消息编号
                        msgChatDao.insert(chat);
                        messageid = chat.getChatid();
                        MsgRecv msgRecv = new MsgRecv();
                        msgRecv.setMessageid(messageid);
                        msgRecv.setSenduserid(msgTask.getSendUserID());
                        msgRecv.setRecvuserid(msgTask.getRevUserID());
                        msgRecv.setMsgtype("2");// 2为聊天消息
                        msgRecv.setState("0");
                        msgRecv.setRecvtype(1);
                        msgRecv.setRecvtime(new Date(msgTask.getmDate()));
                        msgRecvDao.insert(msgRecv);// 将未读消息插入消息记录表中，返回SIGN
                        sign = msgRecv.getRecvid();
                        UserNode userNode = SysInfo.getInstance().getAppNodeById(msgTask.getRevUserID());
                        System.out.println(userNode != null);
                        if (userNode != null) {
                            byte[] packPkt = PackPkt(msgTask, chat, userNode);
                            userNode.getIoSession().write(IoBuffer.wrap(packPkt));
                            userNode.setLastPacketInfo(packPkt);// 更新缓存
                        }
                        SysInfo.getInstance().removeMsgTask(msgTask);
                    } else {
                        SysInfo.getInstance().removeMsgTask(msgTask);//如果该消息是聊天消息，但接受者id不大于一万，直接删除该消息，无效
                    }
                } else if (msgTask.getmType() == 4) {//0 所有APP用户；2 所有设备管理员；3 厂商设备用户；4管理员；5全体所有成员
                    logger.debug("该消息为通知消息-->");
                    MsgNotice notice = new MsgNotice();
                    notice.setSendid(msgTask.getSendUserID());
                    notice.setSendtime(new Date(msgTask.getmDate()));
                    String title = JsonAnalysis.getValue(msgTask.getContent(), "TITLE");
                    String msg = JsonAnalysis.getValue(msgTask.getContent(), "MSG");
                    String set = JsonAnalysis.getValue(msgTask.getContent(), "SET");
                    notice.setMsg(msg);
                    notice.setTitle(title);
                    notice.setSets(set);
                    if (msgTask.getRevUserID() == 0) {// 系统通告，发送给所有APP用户
                        logger.debug("系统通告，发送给所有APP用户-->");
                        notice.setRecvtype(1);
                        msgNoticeDao.insert(notice);
                        messageid = notice.getNoticeid();
                        List<UserInf> user = userDao.selectAllUser();//查询所有APP用户id

                        for (int i = 0; i < user.size(); i++) {
                            logger.debug(user.get(i).getUserid().toString());
                            MsgRecv msgRecv = new MsgRecv();
                            msgRecv.setMessageid(messageid);
                            msgRecv.setMsgtype("4");
                            msgRecv.setRecvtype(1);
                            msgRecv.setRecvtime(new Date(msgTask.getmDate()));
                            msgRecv.setState("0");
                            msgRecv.setSenduserid(msgTask.getSendUserID());
                            msgRecv.setRecvuserid(user.get(i).getUserid());
                            msgRecvDao.insert(msgRecv);
                            sign = msgRecv.getRecvid();
                            UserNode userNode;
                            if ((userNode = SysInfo.getInstance().getAppNodeById(user.get(i).getUserid())) != null) {
                                logger.debug(userNode.toString());
                                byte[] packPkt = PackPkt(msgTask, notice, userNode);
                                userNode.getIoSession().write(IoBuffer.wrap(packPkt));
                                userNode.setLastPacketInfo(packPkt);// 更新缓存
                            }
                        }
                        SysInfo.getInstance().removeMsgTask(msgTask);
                    } else if (msgTask.getRevUserID() == 2) {//设备管理员
                        MsgRecv msgRecv = new MsgRecv();
                        notice.setRecvtype(2);
                        messageid = msgNoticeDao.insert(notice);
                        List<RelateInf> list = relateDao.findManagerIdByDeviceId(msgTask.getSendUserID());
                        for (int i = 0; i < list.size(); i++) {
                            msgRecv.setMessageid(messageid);
                            msgRecv.setRecvtime(new Date(msgTask.getmDate()));
                            msgRecv.setState("0");
                            msgRecv.setRecvtype(1);
                            msgRecv.setSenduserid(msgTask.getSendUserID());
                            msgRecv.setRecvuserid(list.get(i).getUserid());
                            msgRecv.setMsgtype("2");
                            msgRecvDao.insert(msgRecv);
                            sign = msgRecv.getRecvid();
                            UserNode userNode = SysInfo.getInstance().getAppNodeById(list.get(i).getUserid());
                            if (userNode != null) {
                                byte[] packPkt = PackPkt(msgTask, notice, userNode);
                                userNode.getIoSession().write(IoBuffer.wrap(packPkt));
                                userNode.setLastPacketInfo(packPkt);// 更新缓存
                            }
                        }
                        SysInfo.getInstance().removeMsgTask(msgTask);
                    } else if (msgTask.getRevUserID() == 3) {//厂商设备用户
                        MsgRecv msgRecv = new MsgRecv();
                        notice.setRecvtype(3);
                        msgRecv.setMsgtype("3");
                        msgNoticeDao.insert(notice);
                        messageid = notice.getNoticeid();
                        msgRecv.setRecvtype(1);
                        List<UserInf> list = userDao.selectAllCompanyUser();
                        for (int i = 0; i < list.size(); i++) {
                            msgRecv.setMessageid(messageid);
                            msgRecv.setRecvtime(new Date(msgTask.getmDate()));
                            msgRecv.setState("0");
                            msgRecv.setSenduserid(msgTask.getSendUserID());
                            msgRecv.setRecvuserid(list.get(i).getUserid());
                            msgRecvDao.insert(msgRecv);
                            sign = msgRecv.getRecvid();
                            UserNode userNode = SysInfo.getInstance().getAppNodeById(list.get(i).getUserid());
                            if (userNode != null) {
                                byte[] packPkt = PackPkt(msgTask, notice, userNode);
                                userNode.getIoSession().write(IoBuffer.wrap(packPkt));
                                userNode.setLastPacketInfo(packPkt);// 更新缓存
                            }
                        }
                        SysInfo.getInstance().removeMsgTask(msgTask);
                    } else if (msgTask.getRevUserID() == 4) {//管理员
                        MsgRecv msgRecv = new MsgRecv();
                        notice.setRecvtype(4);
                        msgRecv.setMsgtype("4");
                        msgRecv.setRecvtype(2);
                        msgNoticeDao.insert(notice);
                        messageid = notice.getNoticeid();
                        List<UserInf> list = userDao.selectAllManagerUser();
                        for (int i = 0; i < list.size(); i++) {
                            msgRecv.setMessageid(messageid);
                            msgRecv.setRecvtime(new Date(msgTask.getmDate()));
                            msgRecv.setState("0");
                            msgRecv.setSenduserid(msgTask.getSendUserID());
                            msgRecv.setRecvuserid(list.get(i).getUserid());
                            msgRecvDao.insert(msgRecv);
                            sign = msgRecv.getRecvid();
                            UserNode userNode = SysInfo.getInstance().getAppNodeById(list.get(i).getUserid());
                            if (userNode != null) {
                                byte[] packPkt = PackPkt(msgTask, notice, userNode);
                                userNode.getIoSession().write(IoBuffer.wrap(packPkt));
                                userNode.setLastPacketInfo(packPkt);// 更新缓存
                            }
                        }
                        SysInfo.getInstance().removeMsgTask(msgTask);
                    } else if (msgTask.getRevUserID() == 5) {//全体所有成员

                    }
                } else {
                    logger.debug("不支持的消息类型,删除该消息");
                    SysInfo.getMsgTaskQueue().remove(msgTask);
                }
            } catch (Exception e) {
                logger.debug("捕获异常，删除节点" + e.getMessage());
            } finally {
                SysInfo.getMsgTaskQueue().remove(msgTask);
            }
        }
    }

    public byte[] PackPkt(MsgTask msgTask, Object c, UserNode userNode) {
        PacketMsg msg = new PacketMsg();
        msg.setCmd(ConstParam.CMD_5);
        msg.setType(ConstParam.TYPE_4);
        msg.setOpt(ConstParam.OPT_8);
        msg.setSid(ConstParam.SERVER_ID);
        int seq = (int) SysInfo.getSysStatInfo().getSendnum() + 1;
        msg.setSeq(seq);
        MsgAlarm alarm = new MsgAlarm();
        MsgChat chat = new MsgChat();
        MsgNotice notice = new MsgNotice();
        JSONObject data = new JSONObject();
        JSONArray infoArray = new JSONArray();
        JSONObject dataChild = new JSONObject();
        JSONObject infoChild = new JSONObject();
        JSONObject contentChild = new JSONObject();
        if (msgTask.getmType() == 1) {//构造报警消息
            alarm = (MsgAlarm) c;
            contentChild.put("SORT", alarm.getSort());
            contentChild.put("LEVEL", alarm.getLevel());
            contentChild.put("ATTACH", alarm.getUrl());
            infoChild.put("CONTENT", contentChild);
            infoChild.put("USER", alarm.getDeviceid());
            infoChild.put("CLASS", 1);
            infoChild.put("DATE", alarm.getTime().getTime());
            infoArray.add(infoChild);
        }
        if (msgTask.getmType() == 2) {//构造聊天消息
            chat = (MsgChat) c;
            contentChild.put("MSG", chat.getMsg());
            contentChild.put("TYPE", chat.getType());
            contentChild.put("COLOR", chat.getColor());
            infoChild.put("CONTENT", contentChild);
            infoChild.put("USER", chat.getSendid());
            infoChild.put("CLASS", 2);
            infoChild.put("DATE", chat.getSendtime());
            infoArray.add(infoChild);
        }
        if (msgTask.getmType() == 4) {//构造通知消息
            notice = (MsgNotice) c;
            contentChild.put("MSG", notice.getMsg());
            contentChild.put("TITLE", notice.getTitle());
            contentChild.put("SET", notice.getSets());
            infoChild.put("CONTENT", contentChild);
            infoChild.put("USER", notice.getSendid());
            infoChild.put("CLASS", 4);
            infoChild.put("DATE", notice.getSendtime());
            infoArray.add(infoChild);
        }
        dataChild.put("INFO", infoArray);
        dataChild.put("NUM", infoArray.size());
        dataChild.put("SIGN", sign);
        data.put("DATA", dataChild);
        msg.setData(data.toString());
        data.clear();
        infoArray.clear();
        dataChild.clear();
        infoChild.clear();
        contentChild.clear();
        return msg.createMessage(msg);
    }

}
