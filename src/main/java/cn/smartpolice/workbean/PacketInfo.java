package cn.smartpolice.workbean;

import java.util.Arrays;
import java.util.Date;

import org.apache.mina.core.session.IoSession;
import org.springframework.stereotype.Component;

/**
 * 
 *
 */
public class PacketInfo {
    private byte[] message; //协议数据缓冲区
	private IoSession ioSession;
    //  基本首部成员
    private byte cmd; //协议类型
    private byte type;  //报文类型
    private byte opt; //标记域，包括是否转发位
    private byte sort; //发送者类型
    private int sid; //发送者报文的设备ID
    private int seq; //发送序号
    private int ack; //确认序号
    //	首部选项成员
    private int did;
	private String sip;
	private int sport;
    private int keyseq;
    //  报文数据域开始位置
    private int datapos;
    //  报文接受时间
	private Date date;
	private AppNode appNode;
    private int length;
    private String data; //报文传输的Jason数据
    private DevNode devNode;

    @Override
    public String toString() {
        return "PacketInfo{" +
                "cmd=" + cmd +
                ", type=" + type +
                ", opt=" + opt +
                ", sort=" + sort +
                ", sid=" + sid +
                ", seq=" + seq +
                ", ack=" + ack +
                ", did=" + did +
                ", sip='" + sip + '\'' +
                ", sport=" + sport +
                ", keyseq=" + keyseq +
                ", datapos=" + datapos +
                ", date=" + date +
                ", appNode=" + appNode +
                ", length=" + length +
                ", data='" + data + '\'' +
                ", devNode=" + devNode +
                '}';
	}

	public byte[] getMessage() {
		return message;
	}

	public void setMessage(byte[] message) {
		this.message = message;
	}

    public IoSession getIoSession() {
        return ioSession;
    }

    public void setIoSession(IoSession ioSession) {
        this.ioSession = ioSession;
    }

	public byte getCmd() {
		return cmd;
	}

	public void setCmd(byte cmd) {
		this.cmd = cmd;
	}

    public byte getType() {
		return type;
	}

    public void setType(byte type) {
		this.type = type;
	}

    public byte getOpt() {
		return opt;
	}

    public void setOpt(byte opt) {
		this.opt = opt;
	}

    public byte getSort() {
		return sort;
	}

    public void setSort(byte sort) {
		this.sort = sort;
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

    public int getDid() {
		return did;
	}

    public void setDid(int did) {
		this.did = did;
	}

    public String getSip() {
		return sip;
	}

    public void setSip(String sip) {
		this.sip = sip;
	}

    public int getSport() {
		return sport;
	}

    public void setSport(int sport) {
		this.sport = sport;
	}

    public int getKeyseq() {
        return keyseq;
    }

    public void setKeyseq(int keyseq) {
        this.keyseq = keyseq;
    }

	public int getDatapos() {
		return datapos;
	}

    public void setDatapos(int datapos) {
		this.datapos = datapos;
	}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AppNode getAppNode() {
        return appNode;
    }

    public void setAppNode(AppNode appNode) {
        this.appNode = appNode;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DevNode getDevNode() {
        return devNode;
    }

    public void setDevNode(DevNode devNode) {
        this.devNode = devNode;
    }
}
