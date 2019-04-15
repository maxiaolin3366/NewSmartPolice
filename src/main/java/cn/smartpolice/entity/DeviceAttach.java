package cn.smartpolice.entity;

public class DeviceAttach {
    private Integer subid;

    private String serial;

    private String iftype;

    private Integer deviceid;

    private String type;

    public Integer getSubid() {
        return subid;
    }

    public void setSubid(Integer subid) {
        this.subid = subid;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public String getIftype() {
        return iftype;
    }

    public void setIftype(String iftype) {
        this.iftype = iftype == null ? null : iftype.trim();
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}