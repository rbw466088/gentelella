package cn.easybuy.entity;

import java.io.Serializable;

/**
 * 订单明细类
 */
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 8496249934586599466L;
	private Integer id;// ID
	private Integer orderId;// 订单ID
	private Integer quantity;// 数量
	private Float cost;// 单价
	private Integer productId;// 商品id

	private Product product;// 商品

	/**
	 * 获取ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取订单ID
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * 设置订单ID
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取商品id
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * 设置商品id
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * 获取数量
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 设置数量
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 获取单价
	 */
	public Float getCost() {
		return cost;
	}

	/**
	 * 设置单价
	 */
	public void setCost(Float cost) {
		this.cost = cost;
	}

	/**
	 * 获取商品对象
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * 设置商品对象
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderId=" + orderId + ", quantity=" + quantity + ", cost=" + cost
				+ ", productId=" + productId + ", product=" + product + "]";
	}
	
	
	
}
