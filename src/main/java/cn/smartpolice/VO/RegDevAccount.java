package cn.smartpolice.VO;

public class RegDevAccount {
    private String devSerial;
    private String devCode;
    private String devLongitude;
    private String devLatitude;
    private int devMaxConLimit;
    private String devType;
    private String devMphone;

    public String getDevSerial() {
        return devSerial;
    }

    public void setDevSerial(String devSerial) {
        this.devSerial = devSerial;
    }

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getDevLongitude() {
        return devLongitude;
    }

    public void setDevLongitude(String devLongitude) {
        this.devLongitude = devLongitude;
    }

    public String getDevLatitude() {
        return devLatitude;
    }

    public void setDevLatitude(String devLatitude) {
        this.devLatitude = devLatitude;
    }

    public int getDevMaxConLimit() {
        return devMaxConLimit;
    }

    public void setDevMaxConLimit(int devMaxConLimit) {
        this.devMaxConLimit = devMaxConLimit;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public String getDevMphone() {
        return devMphone;
    }

    public void setDevMphone(String devMphone) {
        this.devMphone = devMphone;
    }
}
