package cn.smartpolice.protocol;

import cn.smartpolice.workbean.PacketInfo;
import org.apache.mina.core.buffer.IoBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProtocolTest extends ProtocolBase {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private PacketInfo revPacket;


    @Override
    public void ParsePktProto(PacketInfo packetInfo) {
        logger.debug("进入联通测试协议-->开始协议解析");
        this.revPacket = packetInfo;
        this.ExecProto();
    }

    @Override
    public void ExecProto() {
        logger.debug("处理联通测试协议-->");
        byte[] packet = PackPkt(1);
        this.SendPkt(packet);
    }

    @Override
    public byte[] PackPkt(int i) {
        PacketMsg msg = new PacketMsg();
        msg.setCmd(ConstParam.CMD_0);
        msg.setType(ConstParam.TYPE_2);
        msg.setOpt(ConstParam.OPT_16);
        msg.setAck(revPacket.getSeq());
        msg.setSid(ConstParam.SERVER_ID);
        return msg.createMessage(msg);
    }

    @Override
    void SendPkt(byte[] sendPacket) {
        revPacket.getIoSession().write(IoBuffer.wrap(sendPacket));
    }

}

