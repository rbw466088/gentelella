package com.YANG.BDQN_shop.dao.feng;

import com.YANG.BDQN_shop.entity.feng.OrderDetail;

public interface IOrderDetailDao {
	/**
	 * 添加订单详情
	 * @param orderDetail
	 * @return
	 */
	public int addOrderDetail(OrderDetail orderDetail);
}
