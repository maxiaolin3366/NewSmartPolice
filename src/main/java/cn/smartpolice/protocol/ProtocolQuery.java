package cn.smartpolice.protocol;

import cn.smartpolice.dao.MsgRecvMapper;
import cn.smartpolice.dao.UserInfMapper;
import cn.smartpolice.entity.UserInf;
import cn.smartpolice.tools.ApplicationContextHelper;
import cn.smartpolice.tools.JsonAnalysis;
import cn.smartpolice.workbean.PacketInfo;
import net.sf.json.JSONObject;
import org.apache.mina.core.buffer.IoBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProtocolQuery extends ProtocolBase implements ConstParam {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String user;
    private byte code;
    private String para;
    private int unReadCount;
    private int sid;
    private MsgRecvMapper msgRecvDao = ApplicationContextHelper.getBean(MsgRecvMapper.class);
    private UserInfMapper userDao = ApplicationContextHelper.getBean(UserInfMapper.class);
    @Override
    void ParsePktProto(PacketInfo packetInfo) {
        try {
            packetInfo = this.revPacket;
            String data = packetInfo.getData();
            user = JsonAnalysis.getValue(data, "USER");
            code = Byte.parseByte(JsonAnalysis.getValue(data, "CODE"));// 64用户id；0所有未读信息数量数；1未读报警消息数；2未读聊天消息数；4未读系统通知数；8未读联系人通知数；16未读关联通知数。
            if (JsonAnalysis.getValue(data, "PARA") != null) {  //扩展
                para = JsonAnalysis.getValue(data, "PARA");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
        } finally {
            unReadCount = -1;//表示出错
            this.ExecProto();

        }
    }

    @Override
    void ExecProto() {
        switch (code) {
            case codeNoRead: //查询所有未读消息个数
                unReadCount = msgRecvDao.selectUnReadAll(this.revPacket.getSid());
                byte[] re = this.PackPkt(0);
                this.SendPkt(re);
                break;
            case codeAlarm:  //查询所有未读报警消息个数
                unReadCount = msgRecvDao.selectUnReadAlarm(this.revPacket.getSid());
                byte[] re2 = this.PackPkt(0);
                this.SendPkt(re2);
                break;
            case codeChat:  //查询所有未读聊天消息个数
                unReadCount = msgRecvDao.selectUnReadChat(this.revPacket.getSid());
                byte[] re3 = this.PackPkt(0);
                this.SendPkt(re3);
                break;
            case codeNoice:  //查询所有未读通知消息个数
                unReadCount = msgRecvDao.selectUnReadNotice(this.revPacket.getSid());
                byte[] re4 = this.PackPkt(0);
                this.SendPkt(re4);
                break;
            case codeNoReadContact:  //查询所有未读联系人通知个数
                break;
            case getCodeNoReadRelated:  //查询所有未读关联通知个数
                break;
            case codeId:  //查询自己的id
                UserInf userInf = userDao.selectUserByUserName(user);
                sid = userInf.getUserid();
                byte[] re7 = this.PackPkt(1);
                this.SendPkt(re7);
                break;


        }

    }

    @Override
    byte[] PackPkt(int i) {
        PacketMsg msg = new PacketMsg();
        msg.setCmd(ConstParam.CMD_4);
        msg.setOpt(ConstParam.OPT_16);
        msg.setAck(revPacket.getSeq());//返回报文的ack与发送过来的报文seq一致
        msg.setSid(ConstParam.SERVER_ID);
        String packetBody = null;
        switch (i) {
            case 0:
                if (revPacket.getType() == ConstParam.TYPE_1) {
                    msg.setType(ConstParam.TYPE_2);
                    JSONObject json = new JSONObject();
                    JSONObject data = new JSONObject();
                    json.put("RET", unReadCount);
                    if (unReadCount == -1) {
                        json.put("INFO", "something is wrong");
                    } else {
                        json.put("INFO", "This is all unread message count");
                    }
                    data.put("DATA", json);
                    packetBody = data.toString();
                }
                break;

            case 1:
                if (revPacket.getType() == ConstParam.TYPE_2) {
                    msg.setType(ConstParam.TYPE_2);
                    JSONObject json = new JSONObject();
                    JSONObject data = new JSONObject();
                    json.put("RET", 0);
                    json.put("ID", sid);
                    json.put("INFO", "查询成功");
                    data.put("DATA", data);
                    packetBody = data.toString();
                }
                break;
        }
        msg.setData(packetBody);
        return msg.createMessage(msg);
    }

    @Override
    void SendPkt(byte[] sendPacket) {
        // TODO Auto-generated method stub
        revPacket.getIoSession().write(IoBuffer.wrap(sendPacket));
    }


}
