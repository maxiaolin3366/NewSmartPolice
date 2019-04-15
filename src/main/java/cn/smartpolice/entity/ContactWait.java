package cn.smartpolice.entity;

import java.util.Date;

public class ContactWait {
    private Integer cwid;

    private Integer masterid;

    private Integer contactedid;

    private String group;

    private Date applytime;

    private String message;

    private String state;

    private String kind;

    private String groupname;

    public Integer getCwid() {
        return cwid;
    }

    public void setCwid(Integer cwid) {
        this.cwid = cwid;
    }

    public Integer getMasterid() {
        return masterid;
    }

    public void setMasterid(Integer masterid) {
        this.masterid = masterid;
    }

    public Integer getContactedid() {
        return contactedid;
    }

    public void setContactedid(Integer contactedid) {
        this.contactedid = contactedid;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
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

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }
}