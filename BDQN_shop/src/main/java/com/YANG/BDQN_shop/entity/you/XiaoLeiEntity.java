package com.YANG.BDQN_shop.entity.you;

public class XiaoLeiEntity {
	
	private int id;
	private String name;
	private int papent;
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
	public int getPapent() {
		return papent;
	}
	public void setPapent(int papent) {
		this.papent = papent;
	}
	public XiaoLeiEntity( String name, int papent) {
		super();
		this.name = name;
		this.papent = papent;
	}
	public XiaoLeiEntity( String name) {
		super();
		this.name = name;
	}
	public XiaoLeiEntity() {
		super();
	}
}
