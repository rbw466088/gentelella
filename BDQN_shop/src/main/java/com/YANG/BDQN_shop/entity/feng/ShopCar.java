package com.YANG.BDQN_shop.entity.feng;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShopCar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7122280843623821035L;
	private Map<String,ShopCarItem> items = new HashMap<String,ShopCarItem>();

	public Map<String,ShopCarItem> getItems() {
		return this.items;
	}

	public void addItem(Product product, long quantity) {
		ShopCarItem item = new ShopCarItem(product, quantity);
		this.items.put(String.valueOf(product.getEpcId()), item);
	}

	public void removeItem(String key) {
		this.items.remove(key);
	}

	public void modifyQuantity(int index, long count) {
		this.items.get(index).setCount(count);
	}

	
	public float getTotalCost() {
		float totalCost = 0;
		for(Map.Entry<String, ShopCarItem> map:this.getItems().entrySet()){
			totalCost += (map.getValue().getCount())*(map.getValue().getProduct().getEpPrice());
		}
		return totalCost;
	}

}
