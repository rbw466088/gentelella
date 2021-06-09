package com.YANG.BDQN_shop.service.feng.impl;

import org.apache.ibatis.session.SqlSession;

import com.YANG.BDQN_shop.dao.feng.IOrderDetailDao;
import com.YANG.BDQN_shop.domain.common.FactoryUtil;
import com.YANG.BDQN_shop.entity.feng.OrderDetail;
import com.YANG.BDQN_shop.service.feng.IOrderDetail;

public class OrderDetailService implements IOrderDetail {
	private IOrderDetailDao orderDetailDao;
	
	public IOrderDetailDao getOrderDetailDao() {
		return orderDetailDao;
	}
	public void setOrderDetailDao(IOrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}
	//SqlSession sqlsession=FactoryUtil.createSqlSession();
	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		//IOrderDetailDao orderDetailDao=sqlsession.getMapper(IOrderDetailDao.class);
		orderDetailDao.addOrderDetail(orderDetail);
		
	}

}
