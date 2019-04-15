package cn.smartpolice.entity;

import java.util.Date;

public class MsgAlarm {
    private Integer alarmid;

    private Date time;

    private Integer deviceid;

    private String url;

    private Integer level;

    private Integer sort;

    public Integer getAlarmid() {
        return alarmid;
    }

    public void setAlarmid(Integer alarmid) {
        this.alarmid = alarmid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}