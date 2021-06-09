package com.YANG.BDQN_shop.entity.you;

import java.sql.Date;

public class LoginEntity {
	private String id = null;
	
	private String pwd;
	private String name;
	private String sex;
	private Date birthday;
	private String birthdays;

	private String identity;
	private String email;
	private String mobile;
	private String address;
	private int euStatus;
	
	
	public int getEuStatus() {
		return euStatus;
	}
	public void setEuStatus(int euStatus) {
		this.euStatus = euStatus;
	}
	public LoginEntity(String id, String pwd, String name, String sex,
			Date birthday,  String identity, String email,
			String mobile, String address) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.identity = identity;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}
	public LoginEntity(  String name,String pwd, String sex,
			String birthdays,String mobile, String address) {
		super();
		this.pwd = pwd;
		this.name = name;
		this.sex = sex;
		this.birthdays = birthdays;
		this.mobile = mobile;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthdays() {
		return birthdays;
	}

	public void setBirthdays(String birthdays) {
		this.birthdays = birthdays;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public LoginEntity(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public LoginEntity() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSexs(){
		if(this.sex.equals("T")){
			return "男";
		}else if(this.sex.equals("F")){
			return "女";
		}
		return "";
	}
}
	