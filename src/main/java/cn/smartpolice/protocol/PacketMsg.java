package cn.smartpolice.protocol;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import cn.smartpolice.tools.JsonAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author maxiaolin
 * 发送报文封装类
 */
@Component
public class PacketMsg implements ConstParam {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private int cmd;
    private int type;
    private int opt;
    private int sid;
    private int seq;
    private int ack;
    private String data;


    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOpt() {
        return opt;
    }

    public void setOpt(int opt) {
        this.opt = opt;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getAck() {
        return ack;
    }

    public void setAck(int ack) {
        this.ack = ack;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public byte[] createMessage(PacketMsg msg) {
        ByteArrayOutputStream ips = new ByteArrayOutputStream();
        DataOutputStream dis = new DataOutputStream(ips);
        byte[] packets = null;
        byte[] bytes;
        String packetBodyJson = null;
        try {
            bytes = "ZNAF".getBytes(StandardCharsets.UTF_8);
            dis.write(bytes);
            dis.write((byte) msg.cmd);
            dis.write((byte) msg.type);
            dis.write((byte) msg.opt);
            dis.write((byte) SORT_3);
            dis.writeInt(ConstParam.SERVER_ID);
            dis.writeInt(msg.getSeq());
            dis.writeInt(msg.getAck());
            if (msg.data != null) {
                packetBodyJson = new JsonAnalysis().getJsonByObject(msg.data);
                byte[] packetBodyJsonByte = null;
                packetBodyJsonByte = packetBodyJson.getBytes(StandardCharsets.UTF_8);
                dis.write(packetBodyJsonByte);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        packets = ips.toByteArray();
        logger.debug("返回协议封装完成-->" + this.toString());
        return packets;
    }

    @Override
    public String toString() {
        return "PacketMsg{" +
                "cmd=" + cmd +
                ", type=" + type +
                ", opt=" + opt +
                ", sid=" + sid +
                ", seq=" + seq +
                ", ack=" + ack +
                ", data='" + data + '\'' +
                '}';
    }
}




