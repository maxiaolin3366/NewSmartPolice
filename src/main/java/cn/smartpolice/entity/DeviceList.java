package cn.smartpolice.entity;

public class DeviceList {
    private Integer deviceListId;

    private Integer companyId;

    private Integer deviceId;

    private String state;

    public Integer getDeviceListId() {
        return deviceListId;
    }

    public void setDeviceListId(Integer deviceListId) {
        this.deviceListId = deviceListId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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