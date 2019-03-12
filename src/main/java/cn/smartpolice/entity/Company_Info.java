package cn.smartpolice.entity;

import java.sql.Date;

public class Company_Info {

	private int id;
	private String name;
	private String reg_address;
	private String business_registration_number;
	private String unified_credit_code;
	private String legal_representative;
	private String type_of_enterprise;
	private String industry;
	private String state;
	private String registered_capital;
	private Date reg_date;
	private Date expire_date;
	private String business_scope;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReg_address() {
		return reg_address;
	}
	public void setReg_address(String reg_address) {
		this.reg_address = reg_address;
	}
	public String getBusiness_registration_number() {
		return business_registration_number;
	}
	public void setBusiness_registration_number(String business_registration_number) {
		this.business_registration_number = business_registration_number;
	}
	public String getUnified_credit_code() {
		return unified_credit_code;
	}
	public void setUnified_credit_code(String unified_credit_code) {
		this.unified_credit_code = unified_credit_code;
	}
	public String getLegal_representative() {
		return legal_representative;
	}
	public void setLegal_representative(String legal_representative) {
		this.legal_representative = legal_representative;
	}
	public String getType_of_enterprise() {
		return type_of_enterprise;
	}
	public void setType_of_enterprise(String type_of_enterprise) {
		this.type_of_enterprise = type_of_enterprise;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRegistered_capital() {
		return registered_capital;
	}
	public void setRegistered_capital(String registered_capital) {
		this.registered_capital = registered_capital;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}
	public String getBusiness_scope() {
		return business_scope;
	}
	public void setBusiness_scope(String business_scope) {
		this.business_scope = business_scope;
	}
	@Override
	public String toString() {
		return "Company_Info [id=" + id + ", name=" + name + ", reg_address=" + reg_address
				+ ", business_registration_number=" + business_registration_number + ", unified_credit_code="
				+ unified_credit_code + ", legal_representative=" + legal_representative + ", type_of_enterprise="
				+ type_of_enterprise + ", industry=" + industry + ", state=" + state + ", registered_capital="
				+ registered_capital + ", reg_date=" + reg_date + ", expire_date=" + expire_date + ", business_scope="
				+ business_scope + "]";
	}

}
