package com.YANG.BDQN_shop.entity.feng;

/**
 * 商品分类实体
 * @author WLF
 *
 */
public class Category {
	private int epcId;			//商品类型偏号
	private String epcName;		//商品类型名称
	private int epcParentId;	//父分类
	
	public int getEpcId() {
		return epcId;
	}
	public void setEpcId(int epcId) {
		this.epcId = epcId;
	}
	public String getEpcName() {
		return epcName;
	}
	public void setEpcName(String epcName) {
		this.epcName = epcName;
	}
	public int getEpcParentId() {
		return epcParentId;
	}
	public void setEpcParentId(int epcParentId) {
		this.epcParentId = epcParentId;
	}
	
	
}
