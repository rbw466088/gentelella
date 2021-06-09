package com.YANG.BDQN_shop.entity.feng;

import java.sql.Date;


public class Order {
	private int eoId;				//订单编号
	private String eoUserId;		//用户Id
	private String eoUserName;		//用户名
	private String eoUserAddress;	//用户地址
	private Date eoCreateTTime;		//创建时间
	private float eoCost;			//金额
	private int eoStatus;			//状态
	private int eoType;

	public Order() {
	}

	
	

	
	public Order(String eoUserId, String eoUserName, String eoUserAddress,
			Date eoCreateTTime, float eoCost, int eoStatus, int eoType) {
		super();
		this.eoUserId = eoUserId;
		this.eoUserName = eoUserName;
		this.eoUserAddress = eoUserAddress;
		this.eoCreateTTime = eoCreateTTime;
		this.eoCost = eoCost;
		this.eoStatus = eoStatus;
		this.eoType = eoType;
	}





	public int getEoType() {
		return eoType;
	}
	public void setEoType(int eoType) {
		this.eoType = eoType;
	}

	public int getEoId() {
		return eoId;
	}

	public void setEoId(int eoId) {
		this.eoId = eoId;
	}

	public String getEoUserId() {
		return eoUserId;
	}

	public void setEoUserId(String eoUserId) {
		this.eoUserId = eoUserId;
	}

	public String getEoUserName() {
		return eoUserName;
	}

	public void setEoUserName(String eoUserName) {
		this.eoUserName = eoUserName;
	}

	public String getEoUserAddress() {
		return eoUserAddress;
	}

	public void setEoUserAddress(String eoUserAddress) {
		this.eoUserAddress = eoUserAddress;
	}

	public Date getEoCreateTTime() {
		return eoCreateTTime;
	}

	public void setEoCreateTTime(Date eoCreateTTime) {
		this.eoCreateTTime = eoCreateTTime;
	}

	public float getEoCost() {
		return eoCost;
	}

	public void setEoCost(float cost) {
		this.eoCost = cost;
	}

	public int getEoStatus() {
		return eoStatus;
	}

	public void setEoStatus(int eoStatus) {
		this.eoStatus = eoStatus;
	}

	public String getEoStatusStr(){
		if(this.eoStatus==1){
			return "待审核";
		}else if(this.eoStatus==2){
			return "审核通过";
		}else if(this.eoStatus==3){
			return "配货";
		}else if(this.eoStatus==4){
			return "卖家已发货";
		}else if(this.eoStatus==5){
			return "已发货";
		}
		return "";
	}
}
