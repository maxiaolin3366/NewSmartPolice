package cn.smartpolice.entity;

public class Oprate {
    private Long oprateid;

    private Integer id;

    private String type;

    public Long getOprateid() {
        return oprateid;
    }

    public void setOprateid(Long oprateid) {
        this.oprateid = oprateid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}