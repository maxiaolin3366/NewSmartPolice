package cn.smartpolice.entity;

import java.sql.Date;

public class Admin_Log {

	private int id;
	private int admin_id;
	private Date login_time;
	private Date logout_time;
	private String oprate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
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
	@Override
	public String toString() {
		return "Admin_Log [id=" + id + ", admin_id=" + admin_id + ", login_time=" + login_time + ", logout_time="
				+ logout_time + ", oprate=" + oprate + "]";
	}
	
}
