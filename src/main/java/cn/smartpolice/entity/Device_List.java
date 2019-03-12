package cn.smartpolice.entity;

public class Device_List {

	private int id;
	private int company_id;
	private int device_id;
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Device_List [id=" + id + ", company_id=" + company_id + ", device_id=" + device_id + ", state=" + state
				+ "]";
	}
	
}
