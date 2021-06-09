package cn.easybuy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户地址类
 */
public class UserAddress implements Serializable {
	private static final long serialVersionUID = -1777214064143198221L;

	private Integer id;// 主键ID

	private String address;// 用户地址

	private Integer userId;// 用户ID

	private Date createTime;// 创建时间

	private String remark;// 备注

	/**
	 * 获取主键ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取用户地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置用户地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取用户ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 设置用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", address=" + address + ", userId=" + userId + ", createTime=" + createTime
				+ ", remark=" + remark + "]";
	}
	
	

}
