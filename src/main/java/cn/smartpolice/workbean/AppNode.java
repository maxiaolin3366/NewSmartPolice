package cn.smartpolice.workbean;

import java.util.Date;

/**
 *  用户节点
 */
public class AppNode extends UserNode {

	private DevNode devData;//最近会话设备节点
	private Date talkDate; //最近会话时间
	
	public DevNode getDevData() {
		return devData;
	}
	public void setDevData(DevNode devData) {
		this.devData = devData;
	}
	public Date getTalkDate() {
		return talkDate;
	}
	public void setTalkDate(Date talkDate) {
		this.talkDate = talkDate;
	}
	
}
