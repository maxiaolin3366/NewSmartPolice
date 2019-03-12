package cn.smartpolice.entity;

public class Device_Info {

	private int id;
	private String serial;
	private int state;
	private String type;
	private int connect_limit;
	private String software_version;
	private String mac;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getConnect_limit() {
		return connect_limit;
	}
	public void setConnect_limit(int connect_limit) {
		this.connect_limit = connect_limit;
	}
	public String getSoftware_version() {
		return software_version;
	}
	public void setSoftware_version(String software_version) {
		this.software_version = software_version;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	@Override
	public String toString() {
		return "Device_Info [id=" + id + ", serial=" + serial + ", state=" + state + ", type=" + type
				+ ", connect_limit=" + connect_limit + ", software_version=" + software_version + ", mac=" + mac + "]";
	}
	
	
}
