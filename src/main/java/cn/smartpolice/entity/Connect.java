package cn.smartpolice.entity;

import java.util.Date;

public class Connect {
    private Integer connectId;

    private Date connectTime;

    private Date disconnectTime;

    private Integer userId;

    private Integer deviceId;

    private String state;

    public Integer getConnectId() {
        return connectId;
    }

    public void setConnectId(Integer connectId) {
        this.connectId = connectId;
    }

    public Date getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(Date connectTime) {
        this.connectTime = connectTime;
    }

    public Date getDisconnectTime() {
        return disconnectTime;
    }

    public void setDisconnectTime(Date disconnectTime) {
        this.disconnectTime = disconnectTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}