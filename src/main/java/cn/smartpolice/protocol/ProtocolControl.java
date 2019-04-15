package cn.smartpolice.protocol;


import java.util.Date;


import org.apache.mina.core.buffer.IoBuffer;


import cn.smartpolice.workbean.PacketInfo;
import cn.smartpolice.workbean.SysInfo;
import cn.smartpolice.workbean.UserNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * cmd = 3(服务器端就只是转发协议)
 */
public class ProtocolControl extends ProtocolBase {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    void ParsePktProto(PacketInfo packetInfo) {
        logger.debug("进入控制协议-->");
        super.revPacket = packetInfo;
        this.ExecProto();
    }

    @Override
    void ExecProto() {
        UserNode userNode = null;
        if (revPacket.getSort() == ConstParam.SORT_0) {  // sort=0报文从app来 转发给dev
            userNode = SysInfo.getInstance().getDevNodeById(revPacket.getDid());
            logger.debug("UserNode是用户Node-->" + userNode);
        }

        if (revPacket.getSort() == ConstParam.SORT_2) {  // sort=2报文从dev来 转发给app
            userNode = SysInfo.getInstance().getAppNodeById(revPacket.getDid());
            logger.debug("UserNode是设备Node-->" + userNode);
        }
/**
 * 设备之间互相控制功能，有待扩展
 */
        if (revPacket.getSort() == ConstParam.SORT_2) {  // sort=2报文从dev来 转发给dev
            userNode = SysInfo.getInstance().getDevNodeById(revPacket.getDid());
            logger.debug("UserNode是设备Node-->" + userNode);
        }

        //节点存在且处于登录状态
        if (userNode != null && userNode.getState() == ConstParam.LOGIN_STATE_2) {
            // 更新节点收到报文的时间
            userNode.setRevPktDate(new Date());
            // 将报文转发给该节点
            userNode.getIoSession().write(IoBuffer.wrap(revPacket.getMessage()));
        }
    }

    @Override
    byte[] PackPkt(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    void SendPkt(byte[] sendPacket) {
        // TODO Auto-generated method stub

    }

}
