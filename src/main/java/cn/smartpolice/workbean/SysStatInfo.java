package cn.smartpolice.workbean;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 系统统计信息
 */

@Component
public class SysStatInfo {

    private long receicvenum; //收到报文数
    private long sendnum; //发送报文数
    private long loginusernum; //登陆用户数
    private long logindevnum; //登陆设备数
    private long viewusernum; //界面用户数
    private long ordernum;
    private long openFileNum; //文件打开数量
    private Date serverStartDate; //服务器启动时间

    @Override
    public String toString() {
        return "SysStatInfo{" +
                "receicvenum=" + receicvenum +
                ", sendnum=" + sendnum +
                ", loginusernum=" + loginusernum +
                ", logindevnum=" + logindevnum +
                ", viewusernum=" + viewusernum +
                ", ordernum=" + ordernum +
                ", openFileNum=" + openFileNum +
                ", serverStartDate=" + serverStartDate +
                '}';
    }

    public long getReceicvenum() {
        return receicvenum;
    }

    public void setReceicvenum(long receicvenum) {
        this.receicvenum = receicvenum;
    }

    public long getSendnum() {
        return sendnum;
    }

    public void setSendnum(long sendnum) {
        this.sendnum = sendnum;
    }

    public long getLoginusernum() {
        return loginusernum;
    }

    public void setLoginusernum(long loginusernum) {
        this.loginusernum = loginusernum;
    }

    public long getLogindevnum() {
        return logindevnum;
    }

    public void setLogindevnum(long logindevnum) {
        this.logindevnum = logindevnum;
    }

    public long getViewusernum() {
        return viewusernum;
    }

    public void setViewusernum(long viewusernum) {
        this.viewusernum = viewusernum;
    }

    public long getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(long ordernum) {
        this.ordernum = ordernum;
    }

    public long getOpenFileNum() {
        return openFileNum;
    }

    public void setOpenFileNum(long openFileNum) {
        this.openFileNum = openFileNum;
    }

    public Date getServerStartDate() {
        return serverStartDate;
    }

    public void setServerStartDate(Date serverStartDate) {
        this.serverStartDate = serverStartDate;
    }
}
	

