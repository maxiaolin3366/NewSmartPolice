package cn.smartpolice.entity;

import java.util.Date;

public class SystemRuninfo {
    private Integer infoid;

    private Date infotime;

    private Integer onlineNownum;

    private Integer displaynum;

    private Integer loginMaxnum;

    private Integer loginDevicenum;

    private Integer filesOpennum;

    private Integer loginMaxdevicenum;

    private Integer loginApp;

    private Integer msgGet;

    private Integer msgSend;

    private String currentusernum;

    private String interfaceusernum;

    private String maxloginusernum;

    private String deviceloginnum;

    private String fileopenednum;

    private String maxlogindevicenum;

    private String apploginnum;

    private String achivemsgnum;

    private String sendmsgnum;

    public Integer getInfoid() {
        return infoid;
    }

    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }

    public Date getInfotime() {
        return infotime;
    }

    public void setInfotime(Date infotime) {
        this.infotime = infotime;
    }

    public Integer getOnlineNownum() {
        return onlineNownum;
    }

    public void setOnlineNownum(Integer onlineNownum) {
        this.onlineNownum = onlineNownum;
    }

    public Integer getDisplaynum() {
        return displaynum;
    }

    public void setDisplaynum(Integer displaynum) {
        this.displaynum = displaynum;
    }

    public Integer getLoginMaxnum() {
        return loginMaxnum;
    }

    public void setLoginMaxnum(Integer loginMaxnum) {
        this.loginMaxnum = loginMaxnum;
    }

    public Integer getLoginDevicenum() {
        return loginDevicenum;
    }

    public void setLoginDevicenum(Integer loginDevicenum) {
        this.loginDevicenum = loginDevicenum;
    }

    public Integer getFilesOpennum() {
        return filesOpennum;
    }

    public void setFilesOpennum(Integer filesOpennum) {
        this.filesOpennum = filesOpennum;
    }

    public Integer getLoginMaxdevicenum() {
        return loginMaxdevicenum;
    }

    public void setLoginMaxdevicenum(Integer loginMaxdevicenum) {
        this.loginMaxdevicenum = loginMaxdevicenum;
    }

    public Integer getLoginApp() {
        return loginApp;
    }

    public void setLoginApp(Integer loginApp) {
        this.loginApp = loginApp;
    }

    public Integer getMsgGet() {
        return msgGet;
    }

    public void setMsgGet(Integer msgGet) {
        this.msgGet = msgGet;
    }

    public Integer getMsgSend() {
        return msgSend;
    }

    public void setMsgSend(Integer msgSend) {
        this.msgSend = msgSend;
    }

    public String getCurrentusernum() {
        return currentusernum;
    }

    public void setCurrentusernum(String currentusernum) {
        this.currentusernum = currentusernum == null ? null : currentusernum.trim();
    }

    public String getInterfaceusernum() {
        return interfaceusernum;
    }

    public void setInterfaceusernum(String interfaceusernum) {
        this.interfaceusernum = interfaceusernum == null ? null : interfaceusernum.trim();
    }

    public String getMaxloginusernum() {
        return maxloginusernum;
    }

    public void setMaxloginusernum(String maxloginusernum) {
        this.maxloginusernum = maxloginusernum == null ? null : maxloginusernum.trim();
    }

    public String getDeviceloginnum() {
        return deviceloginnum;
    }

    public void setDeviceloginnum(String deviceloginnum) {
        this.deviceloginnum = deviceloginnum == null ? null : deviceloginnum.trim();
    }

    public String getFileopenednum() {
        return fileopenednum;
    }

    public void setFileopenednum(String fileopenednum) {
        this.fileopenednum = fileopenednum == null ? null : fileopenednum.trim();
    }

    public String getMaxlogindevicenum() {
        return maxlogindevicenum;
    }

    public void setMaxlogindevicenum(String maxlogindevicenum) {
        this.maxlogindevicenum = maxlogindevicenum == null ? null : maxlogindevicenum.trim();
    }

    public String getApploginnum() {
        return apploginnum;
    }

    public void setApploginnum(String apploginnum) {
        this.apploginnum = apploginnum == null ? null : apploginnum.trim();
    }

    public String getAchivemsgnum() {
        return achivemsgnum;
    }

    public void setAchivemsgnum(String achivemsgnum) {
        this.achivemsgnum = achivemsgnum == null ? null : achivemsgnum.trim();
    }

    public String getSendmsgnum() {
        return sendmsgnum;
    }

    public void setSendmsgnum(String sendmsgnum) {
        this.sendmsgnum = sendmsgnum == null ? null : sendmsgnum.trim();
    }
}