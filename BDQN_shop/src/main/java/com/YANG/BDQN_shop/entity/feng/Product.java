package com.YANG.BDQN_shop.entity.feng;

public class Product {
	private int epId;				//商品编号
	private String epName;			//商品名称
	private String epDescription;	//商品描述
	private float epPrice;			//商品价格
	private int epStock;			//商品库存
	private int epcId;				//所属分类
	private int epcChildId;			//所属二级分类
	private String epFileName;		//上传的文件名
	
	public int getEpId() {
		return epId;
	}
	public void setEpId(int epId) {
		this.epId = epId;
	}
	public String getEpName() {
		return epName;
	}
	public void setEpName(String epName) {
		this.epName = epName;
	}
	public String getEpDescription() {
		return epDescription;
	}
	public void setEpDescription(String epDescription) {
		this.epDescription = epDescription;
	}
	public float getEpPrice() {
		return epPrice;
	}
	public void setEpPrice(float epPrice) {
		this.epPrice = epPrice;
	}
	public int getEpStock() {
		return epStock;
	}
	public void setEpStock(int epStock) {
		this.epStock = epStock;
	}
	public int getEpcId() {
		return epcId;
	}
	public void setEpcId(int epcId) {
		this.epcId = epcId;
	}
	public int getEpcChildId() {
		return epcChildId;
	}
	public void setEpcChildId(int epcChildId) {
		this.epcChildId = epcChildId;
	}
	public String getEpFileName() {
		return epFileName;
	}
	public void setEpFileName(String epFileName) {
		this.epFileName = epFileName;
	}
	
	public String getEpStockStr(){
		if(this.epStock>0){
			return "有货";
		}else if(this.epStock<=0){
			return "缺货";
		}
		return "";
	}
}
