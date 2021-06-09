package com.YANG.BDQN_shop.entity.yang;

import java.sql.Date;

public class News {
	private int enId;
	private String enTitle;
	private String enContent;
	private Date enCreateTime;
	
	
	public int getEnId() {
		return enId;
	}
	public void setEnId(int enId) {
		this.enId = enId;
	}
	public String getEnTitle() {
		return enTitle;
	}
	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle;
	}
	public String getEnContent() {
		return enContent;
	}
	public void setEnContent(String enContent) {
		this.enContent = enContent;
	}
	public Date getEnCreateTime() {
		return enCreateTime;
	}
	public void setEnCreateTime(Date enCreateTime) {
		this.enCreateTime = enCreateTime;
	}
	
	
}
