package cn.smartpolice.entity;

import java.sql.Date;

public class User_Log {

	private int id;
	private int user_id;
	private Date login_time;
	private Date logout_time;
	private String oprate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	public Date getLogout_time() {
		return logout_time;
	}
	public void setLogout_time(Date logout_time) {
		this.logout_time = logout_time;
	}
	public String getOprate() {
		return oprate;
	}
	public void setOprate(String oprate) {
		this.oprate = oprate;
	}
}
