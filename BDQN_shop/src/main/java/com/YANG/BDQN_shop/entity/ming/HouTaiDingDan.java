package com.YANG.BDQN_shop.entity.ming;

import java.io.Serializable;

public class HouTaiDingDan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5453474389192937246L;
	//上传的文件名
	private String epfilename;
	//商品名字
	private String epname;
	//商品价格
	private int epprice;
	//数量
	private int eodquantity;
	//状态̬
	private int eostatus;
	//订单编号
	private int eoid;
	//用户名
	private String eousername;
	//创建时间
	private String eocreatetime;
	
	private Integer id;
	
	private String names;
	
	private String userid;
	
	

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	
	
	
	
	
	
	
	public String getEpname() {
		return epname;
	}
	public void setEpname(String epname) {
		this.epname = epname;
	}
	public String getEocreatetime() {
		return eocreatetime;
	}
	public void setEocreatetime(String eocreatetime) {
		this.eocreatetime = eocreatetime;
	}
	public int getEoid() {
		return eoid;
	}
	public void setEoid(int eoid) {
		this.eoid = eoid;
	}
	public String getEousername() {
		return eousername;
	}
	public void setEousername(String eousername) {
		this.eousername = eousername;
	}
	public String getEpfilename() {
		return epfilename;
	}
	public void setEpfilename(String epfilename) {
		this.epfilename = epfilename;
	}
	public int getEpprice() {
		return epprice;
	}
	public void setEpprice(int epprice) {
		this.epprice = epprice;
	}
	public int getEodquantity() {
		return eodquantity;
	}
	public void setEodquantity(int eodquantity) {
		this.eodquantity = eodquantity;
	}
	public int getEostatus() {
		return eostatus;
	}
	public void setEostatus(int eostatus) {
		this.eostatus = eostatus;
	}
}
