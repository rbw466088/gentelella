package com.YANG.BDQN_shop.dao.feng;

import java.util.List;

import com.YANG.BDQN_shop.entity.feng.ProductType;

public interface IProductTypeDao {
	/**
	 * 获取所有父分类
	 * @return
	 */
	public List<ProductType> findAll();
}
