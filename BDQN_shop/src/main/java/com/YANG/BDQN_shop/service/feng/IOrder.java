package com.YANG.BDQN_shop.service.feng;

import java.util.List;

import com.YANG.BDQN_shop.entity.feng.Order;
import com.YANG.BDQN_shop.entity.you.LoginEntity;

public interface IOrder {
	/**
	 * 添加订单
	 * @param order
	 * @return
	 */
	public int addOrder(Order order);
	
	/**
	 * 获取对应用户的订单总记录
	 * @param user
	 * @return
	 */
	public int finadOrder(String user);
	
	/**
	 * 获取用户ID信息（用来判断是普通用户还是管理员）
	 * @param id
	 * @return
	 */
	public List<LoginEntity> findAlls(String eoUserId);
}
