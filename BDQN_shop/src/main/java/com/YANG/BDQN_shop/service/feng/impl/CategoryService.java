package com.YANG.BDQN_shop.service.feng.impl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.YANG.BDQN_shop.dao.feng.ICategoryDao;
import com.YANG.BDQN_shop.domain.common.FactoryUtil;
import com.YANG.BDQN_shop.entity.feng.Category;
import com.YANG.BDQN_shop.exception.ServiceException;
import com.YANG.BDQN_shop.service.feng.ICategory;

public class CategoryService implements ICategory {
	private ICategoryDao categoryDao;
	
	public ICategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> findAll() throws ServiceException{
		/*SqlSession sqlsession=null;
		sqlsession=FactoryUtil.createSqlSession();
		ICategoryDao categorydao=sqlsession.getMapper(ICategoryDao.class);
		List<Category> categoryList=categorydao.findAll();
		
		return categoryList;*/
		
		try {
			List<Category> categoryList=categoryDao.findAll();
			return categoryList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
