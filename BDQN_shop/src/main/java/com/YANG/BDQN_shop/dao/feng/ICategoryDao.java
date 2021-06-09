package com.YANG.BDQN_shop.dao.feng;

import java.util.List;

import com.YANG.BDQN_shop.entity.feng.Category;

public interface ICategoryDao {
	/**
	 * 获取所有子分类信息
	 * @return
	 */
	public List<Category> findAll();
}
