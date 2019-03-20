package cn.smartpolice.workbean;

import java.util.Date;
import java.util.List;

public class FileNode {
    private String fileName;
    private String MD5;
    private long fileSize;
    private String type; //下载或者上传
    private Date askTime; //最近请求时间
    private List<FileUsing> usingFile;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getAskTime() {
        return askTime;
    }

    public void setAskTime(Date askTime) {
        this.askTime = askTime;
    }

    public List<FileUsing> getUsingFile() {
        return usingFile;
    }

    public void setUsingFile(List<FileUsing> usingFile) {
        this.usingFile = usingFile;
    }
}
