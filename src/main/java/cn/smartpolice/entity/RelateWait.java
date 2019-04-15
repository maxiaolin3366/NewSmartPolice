package cn.smartpolice.entity;

import java.util.Date;

public class RelateWait {
    private Integer rwid;

    private Integer applyid;

    private Integer deviceid;

    private Integer askid;

    private Boolean applytype;

    private String applyright;

    private Date applytime;

    private String message;

    private String state;

    private String kind;

    private Integer cwid;

    private Date acktime;

    public Integer getRwid() {
        return rwid;
    }

    public void setRwid(Integer rwid) {
        this.rwid = rwid;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public Integer getAskid() {
        return askid;
    }

    public void setAskid(Integer askid) {
        this.askid = askid;
    }

    public Boolean getApplytype() {
        return applytype;
    }

    public void setApplytype(Boolean applytype) {
        this.applytype = applytype;
    }

    public String getApplyright() {
        return applyright;
    }

    public void setApplyright(String applyright) {
        this.applyright = applyright == null ? null : applyright.trim();
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public Integer getCwid() {
        return cwid;
    }

    public void setCwid(Integer cwid) {
        this.cwid = cwid;
    }

    public Date getAcktime() {
        return acktime;
    }

    public void setAcktime(Date acktime) {
        this.acktime = acktime;
    }
}