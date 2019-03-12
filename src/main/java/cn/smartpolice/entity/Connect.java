package cn.smartpolice.entity;

import java.sql.Date;

public class Connect {

	private int id;
	private Date connect_time;
	private Date disconnect_time;
	private int user_id;
	private int device_id;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getConnect_time() {
		return connect_time;
	}
	public void setConnect_time(Date connect_time) {
		this.connect_time = connect_time;
	}
	public Date getDisconnect_time() {
		return disconnect_time;
	}
	public void setDisconnect_time(Date disconnect_time) {
		this.disconnect_time = disconnect_time;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Connect [id=" + id + ", connect_time=" + connect_time + ", disconnect_time=" + disconnect_time
				+ ", user_id=" + user_id + ", device_id=" + device_id + ", state=" + state + "]";
	}
	
	
}
