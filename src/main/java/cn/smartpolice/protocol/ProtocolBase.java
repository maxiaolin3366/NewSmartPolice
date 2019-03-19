package cn.smartpolice.protocol;


import cn.smartpolice.workbean.PacketInfo;



public abstract class ProtocolBase {

    PacketInfo revPacket = new PacketInfo();//子协议特有数据对???

    abstract void ParsePktProto(PacketInfo packetInfo); //解析????协??

    abstract void ExecProto(); //子协议处???

    abstract byte[] PackPkt(int i); //子协议封装协议报???

    abstract void SendPkt(byte[] sendPacket); //发???一个协议报文处??

}
