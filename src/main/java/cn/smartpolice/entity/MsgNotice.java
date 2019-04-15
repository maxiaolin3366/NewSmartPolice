package cn.smartpolice.entity;

import java.util.Date;

public class MsgNotice {
    private Integer noticeid;

    private String title;

    private String msg;

    private Integer sendid;

    private Date sendtime;

    private Integer recvid;

    private String sets;

    private Integer recvtype;

    public Integer getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(Integer noticeid) {
        this.noticeid = noticeid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Integer getSendid() {
        return sendid;
    }

    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getRecvid() {
        return recvid;
    }

    public void setRecvid(Integer recvid) {
        this.recvid = recvid;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets == null ? null : sets.trim();
    }

    public Integer getRecvtype() {
        return recvtype;
    }

    public void setRecvtype(Integer recvtype) {
        this.recvtype = recvtype;
    }
}