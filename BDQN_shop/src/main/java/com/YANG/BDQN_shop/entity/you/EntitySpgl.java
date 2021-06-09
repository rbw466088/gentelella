package com.YANG.BDQN_shop.entity.you;

public class EntitySpgl {
	private int epid;
	private String epname;
	private String epdescription;
	private float epprice;
	private int epstock;
	private int epcid;
	private int epcchildid;
	private String epfilename;
	
	public int getEpid() {
		return epid;
	}
	public void setEpid(int epid) {
		this.epid = epid;
	}
	public String getEpname() {
		return epname;
	}
	public void setEpname(String epname) {
		this.epname = epname;
	}
	public String getEpdescription() {
		return epdescription;
	}
	public void setEpdescription(String epdescription) {
		this.epdescription = epdescription;
	}
	public float getEpprice() {
		return epprice;
	}
	public void setEpprice(float epprice) {
		this.epprice = epprice;
	}
	public int getEpstock() {
		return epstock;
	}
	public void setEpstock(int epstock) {
		this.epstock = epstock;
	}
	public int getEpcid() {
		return epcid;
	}
	public void setEpcid(int epcid) {
		this.epcid = epcid;
	}
	public int getEpcchildid() {
		return epcchildid;
	}
	public void setEpcchildid(int epcchildid) {
		this.epcchildid = epcchildid;
	}
	public String getEpfilename() {
		return epfilename;
	}
	public void setEpfilename(String epfilename) {
		this.epfilename = epfilename;
	}
	
	
	public EntitySpgl(){

	}
	
	public EntitySpgl(int epid, String epname, String epdescription, float epprice, int epstock, int epcid,
			int epcchildid, String epfilename) {
		super();
		this.epid = epid;
		this.epname = epname;
		this.epdescription = epdescription;
		this.epprice = epprice;
		this.epstock = epstock;
		this.epcid = epcid;
		this.epcchildid = epcchildid;
		this.epfilename = epfilename;
	}
	
}
