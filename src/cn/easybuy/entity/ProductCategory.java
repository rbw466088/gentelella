package cn.easybuy.entity;

import java.io.Serializable;

/**
 * 商品明细表
 */
public class ProductCategory implements Serializable {
	private static final long serialVersionUID = -6046541741698174337L;

	private Integer id;// 商品明细表ID
	private String name;// 名称
	private Integer parentId;// 父级ID
	private Integer type;// 分类级别
	private String iconClass;// 图标名称
	private String parentName;// 父级名称

	/**
	 * 获取商品明细表ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置商品明细表ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取父级ID
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * 设置父级ID
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取分类级别
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置分类级别
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取图标名称
	 */
	public String getIconClass() {
		return iconClass;
	}

	/**
	 * 设置图标名称
	 */
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	/**
	 * 获取父级名称
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * 设置父级名称
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", parentId=" + parentId + ", type=" + type
				+ ", iconClass=" + iconClass + ", parentName=" + parentName + "]";
	}
	
	

}
