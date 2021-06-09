package com.YANG.BDQN_shop.entity.feng;

public class ShopCarItem {
	private Product product;
	private long count=0;
	private float cost;
	
	public ShopCarItem(Product product, long count) {
		this.product = product;
		this.count = count;
		this.cost = (float) (product.getEpPrice() * 1);
	}
	public ShopCarItem() {
		super();
	}
	public float getCost() {
		return this.cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
		this.cost=(float)(product.getEpPrice()*count);
	}
	
}
