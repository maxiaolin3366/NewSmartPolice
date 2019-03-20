package cn.smartpolice.workbean;

import java.util.Date;
import java.util.HashMap;

import org.apache.mina.core.session.IoSession;

/**
 * 
 * @author 
 *
 */
public class UserNode {

	private String ip;
	private int port;
	private String Account;
	private int id;//sid
    private long loginDate; //登陆时间
    private Date revPktDate;  //最近收到信息时间
    private int revPktId; //最近收到报文序号
    private int sntPktId; //最近发送报文序号
    private Date sntPktDate; //最近发送报文时间
    private byte[] lastPacketInfo;  //最近发送报文内容
    private IoSession ioSession; //通信会话对象
	private int state; 
	private int link;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

    public int getPort() {
		return port;
	}

    public void setPort(int port) {
		this.port = port;
	}

    public String getAccount() {
		return Account;
	}

    public void setAccount(String account) {
		Account = account;
	}

    public int getId() {
		return id;
	}

    public void setId(int id) {
		this.id = id;
	}

    public long getLoginDate() {
		return loginDate;
	}

    public void setLoginDate(long loginDate) {
		this.loginDate = loginDate;
	}

    public Date getRevPktDate() {
		return revPktDate;
	}

    public void setRevPktDate(Date revPktDate) {
		this.revPktDate = revPktDate;
	}

    public int getRevPktId() {
		return revPktId;
	}

    public void setRevPktId(int revPktId) {
		this.revPktId = revPktId;
	}

    public int getSntPktId() {
		return sntPktId;
	}

    public void setSntPktId(int sntPktId) {
		this.sntPktId = sntPktId;
	}

    public Date getSntPktDate() {
        return sntPktDate;
    }

    public void setSntPktDate(Date sntPktDate) {
        this.sntPktDate = sntPktDate;
    }

    public byte[] getLastPacketInfo() {
        return lastPacketInfo;
    }

    public void setLastPacketInfo(byte[] lastPacketInfo) {
        this.lastPacketInfo = lastPacketInfo;
    }

	public IoSession getIoSession() {
		return ioSession;
	}

    public void setIoSession(IoSession ioSession) {
		this.ioSession = ioSession;
	}

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }
}
