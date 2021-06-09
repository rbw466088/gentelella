package com.YANG.BDQN_shop.entity.feng;

public class OrderDetail {
	private int eodId;			//订单详情编号
	private int eoId;			//订单ID
	private int epId;			//商品ID
	private int eodQuantity;	//数量
	private float eodCost;		//金额
	public OrderDetail() {
	}

	public OrderDetail( int eoId, int epId,
			int eodQuantity, float eodCost) {
		this.eoId = eoId;
		this.epId = epId;
		this.eodQuantity = eodQuantity;
		this.eodCost = eodCost;
	}

	public int getEodId() {
		return eodId;
	}

	public void setEodId(int eodId) {
		this.eodId = eodId;
	}

	public int getEoId() {
		return eoId;
	}

	public void setEoId(int eoId) {
		this.eoId = eoId;
	}

	public int getEpId() {
		return epId;
	}

	public void setEpId(int epId) {
		this.epId = epId;
	}

	public int getEodQuantity() {
		return eodQuantity;
	}

	public void setEodQuantity(int eodQuantity) {
		this.eodQuantity = eodQuantity;
	}

	public float getEodCost() {
		return eodCost;
	}

	public void setEodCost(float eodCost) {
		this.eodCost = eodCost;
	}

	

}
