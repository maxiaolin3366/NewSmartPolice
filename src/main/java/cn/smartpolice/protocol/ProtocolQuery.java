package cn.smartpolice.protocol;

import cn.smartpolice.tools.JsonAnalysis;
import cn.smartpolice.workbean.PacketInfo;
import org.apache.mina.core.buffer.IoBuffer;

/**
 * @author 刘培煊
 * cmd=4
 * 数据查询协议
 */

public class ProtocolQuery extends ProtocolBase implements ConstParam {

    private String user;
    private byte code;
    private String para;

    @Override
    void ParsePktProto(PacketInfo packetInfo) {
        packetInfo = this.revPacket;
        String data = packetInfo.getData();
        user = JsonAnalysis.getValue(data, "USER");
        code = Byte.parseByte(JsonAnalysis.getValue(data, "CODE"));// 64用户id；0所有未读信息数量数；1未读报警消息数；2未读聊天消息数；4未读系统通知数；8未读联系人通知数；16未读关联通知数。
        if (JsonAnalysis.getValue(data, "PARA") != null) {  //扩展
            para = JsonAnalysis.getValue(data, "PARA");
        }
        this.ExecProto();
    }

    @Override
    void ExecProto() {
        switch (code) {
            case codeNoRead: //查询所有未读消息个数

                break;
            case codeAlarm:  //查询所有未读报警消息个数
                break;
            case codeChat:  //查询所有未读聊天消息个数
                break;
            case codeNoice:  //查询所有未读通知消息个数
                break;
            case codeNoReadContact:  //查询所有未读联系人通知个数
                break;
            case getCodeNoReadRelated:  //查询所有未读关联通知个数
                break;
            case codeId:  //查询所有未读消息个数
                break;


        }

    }

    @Override
    byte[] PackPkt(int i) {
        return new byte[0];
    }

    @Override
    void SendPkt(byte[] sendPacket) {
        // TODO Auto-generated method stub
        revPacket.getIoSession().write(IoBuffer.wrap(sendPacket));
    }


}
