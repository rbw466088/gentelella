package cn.easybuy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单类
 */
public class Order implements Serializable {
	private static final long serialVersionUID = 7007242518629314006L;
	private Integer id;//ID
	private String serialNumber;//订单号
	private Integer userId;//用户id
	private String userAddress;//收货地址
	private Date createTime;//创建时间
	private Float cost;//订单总计价格
	
	private String loginName;//登录名称
	private List<OrderDetail> orderDetailList;//订单明细列表

	/**
	 * 获取订单明细列表
	 */
	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	/**
	 * 设置订单明细列表
	 */
	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	/**
	 * 获取订单id
	 */
	public int getId() {
		return id;
	}
	/**
	 * 设置订单id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 设置订单id
	 */
	public void setId(int id) {
		this.id = id;
	}
	

	/**
	 * 获取登录名称
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置登录名称
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	 * 获取订单总计价格
	 */
	public Float getCost() {
		return cost;
	}

	/**
	 * 设置订单总计价格
	 */
	public void setCost(Float cost) {
		this.cost = cost;
	}

	/**
	 * 获取用户id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 设置用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	/**
	 * 获取收货地址
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * 设置收货地址
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * 获取hashCode
	 */
	@Override
	public int hashCode() {		
		return id;
	}

	/**
	 * 比较对象的方法equals
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Order){
			if(((Order)obj).id==id){
				return true;
			}			
		}	
		return false;
	}

	/**
	 * 获取订单号
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * 设置订单号
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", serialNumber=" + serialNumber + ", userId=" + userId + ", userAddress="
				+ userAddress + ", createTime=" + createTime + ", cost=" + cost + ", loginName=" + loginName
				+ ", orderDetailList=" + orderDetailList + "]";
	}
	
	
	
}
