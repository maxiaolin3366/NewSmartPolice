package cn.smartpolice.VO;

import java.util.Date;

public class RegAppAccount {

    private String appAuthority;
    private String appName;
    private Date appBirth;
    private String appSex;
    private String appMail;
    private String appType;
    private String appMphone;

    @Override
    public String toString() {
        return "RegAppAccount{" +
                "appAuthority='" + appAuthority + '\'' +
                ", appName='" + appName + '\'' +
                ", appBirth=" + appBirth +
                ", appSex='" + appSex + '\'' +
                ", appMail='" + appMail + '\'' +
                ", appType='" + appType + '\'' +
                ", appMphone='" + appMphone + '\'' +
                '}';
    }

    public String getAppAuthority() {
        return appAuthority;
    }

    public void setAppAuthority(String appAuthority) {
        this.appAuthority = appAuthority;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Date getAppBirth() {
        return appBirth;
    }

    public void setAppBirth(Date appBirth) {
        this.appBirth = appBirth;
    }

    public String getAppSex() {
        return appSex;
    }

    public void setAppSex(String appSex) {
        this.appSex = appSex;
    }

    public String getAppMail() {
        return appMail;
    }

    public void setAppMail(String appMail) {
        this.appMail = appMail;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppMphone() {
        return appMphone;
    }

    public void setAppMphone(String appMphone) {
        this.appMphone = appMphone;
    }
}
