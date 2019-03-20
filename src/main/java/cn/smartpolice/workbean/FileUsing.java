package cn.smartpolice.workbean;

import org.springframework.stereotype.Component;

@Component
public class FileUsing {
    private Integer sid; //文件使用者ID
    private String typeName;  //文件使用者对象（用户 or 设备）

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
