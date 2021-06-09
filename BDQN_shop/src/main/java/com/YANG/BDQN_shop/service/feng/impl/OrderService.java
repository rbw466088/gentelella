package com.YANG.BDQN_shop.service.feng.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.YANG.BDQN_shop.dao.feng.IOrderDao;
import com.YANG.BDQN_shop.domain.common.FactoryUtil;
import com.YANG.BDQN_shop.entity.feng.Order;
import com.YANG.BDQN_shop.entity.you.LoginEntity;
import com.YANG.BDQN_shop.service.feng.IOrder;

public class OrderService implements IOrder {
	//SqlSession sqlsession=FactoryUtil.createSqlSession();
	private IOrderDao orderDao;

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public int addOrder(Order order) {
		//IOrderDao orderDao = sqlsession.getMapper(IOrderDao.class);
		int result=orderDao.addOrder(order);
		return result;
	}

	@Override
	public int finadOrder(String user) {
		//IOrderDao orderDao = sqlsession.getMapper(IOrderDao.class);
		int result=orderDao.finadOrder(user);
		return result;
	}

	@Override
	public List<LoginEntity> findAlls(String eoUserId) {
		//IOrderDao orderDao=sqlsession.getMapper(IOrderDao.class);
		List<LoginEntity> list=orderDao.findAlls(eoUserId);
		return list;
	}

}
