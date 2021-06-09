package com.YANG.BDQN_shop.entity.yang;

import java.sql.Date;

//留言实体类
public class Comment {
	private int ecId;
	private String ecContent;
	private Date ecCreateTime;
	private String ecReply;
	private Date ecReplyTime;
	private String ecNickName;
	
	
	public Comment(String ecContent, Date ecCreateTime, String ecNickName) {
		super();
		this.ecContent = ecContent;
		this.ecCreateTime = ecCreateTime;
		this.ecNickName = ecNickName;
	}
	public Comment() {
		super();
	}
	public int getEcId() {
		return ecId;
	}
	public void setEcId(int ecId) {
		this.ecId = ecId;
	}
	public String getEcContent() {
		return ecContent;
	}
	public void setEcContent(String ecContent) {
		this.ecContent = ecContent;
	}
	public Date getEcCreateTime() {
		return ecCreateTime;
	}
	public void setEcCreateTime(Date ecCreateTime) {
		this.ecCreateTime = ecCreateTime;
	}
	public String getEcReply() {
		return ecReply;
	}
	public void setEcReply(String ecReply) {
		this.ecReply = ecReply;
	}
	public Date getEcReplyTime() {
		return ecReplyTime;
	}
	public void setEcReplyTime(Date ecReplyTime) {
		this.ecReplyTime = ecReplyTime;
	}
	public String getEcNickName() {
		return ecNickName;
	}
	public void setEcNickName(String ecNickName) {
		this.ecNickName = ecNickName;
	}
	
	
}
