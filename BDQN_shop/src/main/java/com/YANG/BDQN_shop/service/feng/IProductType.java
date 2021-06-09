package com.YANG.BDQN_shop.service.feng;

import java.util.List;

import com.YANG.BDQN_shop.entity.feng.ProductType;
import com.YANG.BDQN_shop.exception.ServiceException;

public interface IProductType {
	/**
	 * 获取所有父分类
	 * @return
	 */
	public List<ProductType> findAll() throws ServiceException ;
}
