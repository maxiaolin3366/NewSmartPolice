package cn.smartpolice.entity;

import java.util.Date;

public class MsgRecv {
    private Integer recvid;

    private Integer recvuserid;

    private String msgtype;

    private Date recvtime;

    private String state;

    private Integer messageid;

    private Integer senduserid;

    private Integer recvtype;

    public Integer getRecvid() {
        return recvid;
    }

    public void setRecvid(Integer recvid) {
        this.recvid = recvid;
    }

    public Integer getRecvuserid() {
        return recvuserid;
    }

    public void setRecvuserid(Integer recvuserid) {
        this.recvuserid = recvuserid;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype == null ? null : msgtype.trim();
    }

    public Date getRecvtime() {
        return recvtime;
    }

    public void setRecvtime(Date recvtime) {
        this.recvtime = recvtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public Integer getSenduserid() {
        return senduserid;
    }

    public void setSenduserid(Integer senduserid) {
        this.senduserid = senduserid;
    }

    public Integer getRecvtype() {
        return recvtype;
    }

    public void setRecvtype(Integer recvtype) {
        this.recvtype = recvtype;
    }
}