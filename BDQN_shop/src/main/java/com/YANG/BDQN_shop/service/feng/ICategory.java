package com.YANG.BDQN_shop.service.feng;

import java.util.List;



import com.YANG.BDQN_shop.entity.feng.Category;
import com.YANG.BDQN_shop.exception.ServiceException;


public interface ICategory {
	/**
	 * 获取所有子分类信息
	 * @return
	 */
	public List<Category> findAll() throws ServiceException  ;
}
