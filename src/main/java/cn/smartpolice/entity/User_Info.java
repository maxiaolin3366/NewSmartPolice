package cn.smartpolice.entity;

import java.sql.Date;

public class User_Info {

	private int id;
	private String username;
	private String password;
	private Date regdate;
	private int state;
	private String real_name;
	private Date birth;
	private int sex;
	private String mail;
	private int role;
	private int role_id;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", password=" + password + ", regdate=" + regdate
				+ ", state=" + state + ", real_name=" + real_name + ", birth=" + birth + ", sex=" + sex + ", mail="
				+ mail + ", role=" + role + ", role_id=" + role_id + ", phone=" + phone + "]";
	}
	
}
