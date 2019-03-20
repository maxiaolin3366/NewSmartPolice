package cn.smartpolice.workbean;

import org.springframework.stereotype.Component;

/**
 * 系统配置信息，将该类设成单例，在系统运行时初始化
 */
public final class SysCfgInfo {
    private int maxLoginDevices; //最大设备登陆数
    private int maxLoginUsers;  //最大登陆用户数
    private String mysqlUserName; //数据库登陆名
    private String mysqlPassword;  //数据库密码
    private short sessionPort; //通信端口
    private short synchronizePort;  //同步服务器端口
    private String synchronizeIp;  //同步服务器IP
    private String sessionPassword;  //服务器间通信认证密码
    private int overtime; //设置用户或设备杯登陆后超时时间

    public int getMaxLoginDevices() {
        return maxLoginDevices;
    }

    public void setMaxLoginDevices(int maxLoginDevices) {
        this.maxLoginDevices = maxLoginDevices;
    }

    public int getMaxLoginUsers() {
        return maxLoginUsers;
    }

    public void setMaxLoginUsers(int maxLoginUsers) {
        this.maxLoginUsers = maxLoginUsers;
    }

    public String getMysqlUserName() {
        return mysqlUserName;
    }

    public void setMysqlUserName(String mysqlUserName) {
        this.mysqlUserName = mysqlUserName;
    }

    public String getMysqlPassword() {
        return mysqlPassword;
    }

    public void setMysqlPassword(String mysqlPassword) {
        this.mysqlPassword = mysqlPassword;
    }

    public short getSessionPort() {
        return sessionPort;
    }

    public void setSessionPort(short sessionPort) {
        this.sessionPort = sessionPort;
    }

    public short getSynchronizePort() {
        return synchronizePort;
    }

    public void setSynchronizePort(short synchronizePort) {
        this.synchronizePort = synchronizePort;
    }

    public String getSynchronizeIp() {
        return synchronizeIp;
    }

    public void setSynchronizeIp(String synchronizeIp) {
        this.synchronizeIp = synchronizeIp;
    }

    public String getSessionPassword() {
        return sessionPassword;
    }

    public void setSessionPassword(String sessionPassword) {
        this.sessionPassword = sessionPassword;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }
}
