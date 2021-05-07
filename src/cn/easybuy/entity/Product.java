package cn.easybuy.entity;

import java.io.Serializable;

/**
 * 商品类
 */
public class Product implements Serializable {
	private static final long serialVersionUID = 8927256969285560550L;
	private Integer id;// 商品ID
	private String name;// 商品名
	private String description;// 商品描述
	private Float price;// 商品单价
	private Integer stock;// 商品数量
	private Integer categoryLevel1Id;// 一级分类
	private Integer categoryLevel2Id;// 二级分类
	private Integer categoryLevel3Id;// 三级分类
	private String fileName;// 图片名称

	/**
	 * hashCode方法
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * equals方法
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * 获取商品ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置商品ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取商品名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置商品名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取商品描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置商品描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取商品单价
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * 设置商品单价
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * 获取商品数量
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * 设置商品数量
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * 获取一级分类
	 */
	public Integer getCategoryLevel1Id() {
		return categoryLevel1Id;
	}

	/**
	 * 设置一级分类
	 */
	public void setCategoryLevel1Id(Integer categoryLevel1Id) {
		this.categoryLevel1Id = categoryLevel1Id;
	}

	/**
	 * 获取二级分类
	 */
	public Integer getCategoryLevel2Id() {
		return categoryLevel2Id;
	}

	/**
	 * 设置二级分类
	 */
	public void setCategoryLevel2Id(Integer categoryLevel2Id) {
		this.categoryLevel2Id = categoryLevel2Id;
	}

	/**
	 * 获取三级分类
	 */
	public Integer getCategoryLevel3Id() {
		return categoryLevel3Id;
	}

	/**
	 * 设置三级分类
	 */
	public void setCategoryLevel3Id(Integer categoryLevel3Id) {
		this.categoryLevel3Id = categoryLevel3Id;
	}

	/**
	 * 获取图片名称
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 设置图片名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", stock="
				+ stock + ", categoryLevel1Id=" + categoryLevel1Id + ", categoryLevel2Id=" + categoryLevel2Id
				+ ", categoryLevel3Id=" + categoryLevel3Id + ", fileName=" + fileName + "]";
	}
	
	
}