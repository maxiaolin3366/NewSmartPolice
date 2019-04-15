package cn.smartpolice.entity;

import java.util.Date;

public class SoftPublish {
    private Integer publishid;

    private String serial;

    private Date begindate;

    private Date enddate;

    private String state;

    public Integer getPublishid() {
        return publishid;
    }

    public void setPublishid(Integer publishid) {
        this.publishid = publishid;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}