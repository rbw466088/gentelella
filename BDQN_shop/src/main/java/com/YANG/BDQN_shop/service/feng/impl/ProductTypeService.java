package com.YANG.BDQN_shop.service.feng.impl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.YANG.BDQN_shop.dao.feng.IProductTypeDao;
import com.YANG.BDQN_shop.domain.common.FactoryUtil;

import com.YANG.BDQN_shop.entity.feng.ProductType;
import com.YANG.BDQN_shop.exception.ServiceException;
import com.YANG.BDQN_shop.service.feng.IProductType;

public class ProductTypeService implements IProductType {
	private IProductTypeDao productTypeDao;
	
	public IProductTypeDao getProductTypeDao() {
		return productTypeDao;
	}

	public void setProductTypeDao(IProductTypeDao productTypeDao) {
		this.productTypeDao = productTypeDao;
	}

	@Override
	public List<ProductType> findAll() throws ServiceException  {
		/*SqlSession sqlsession=null;
		sqlsession=FactoryUtil.createSqlSession();
			
		IProductTypeDao productTypeDao = sqlsession.getMapper(IProductTypeDao.class);
		List<ProductType> typeList=productTypeDao.findAll();
		return typeList;*/
		
		try {
			List<ProductType> typeList=productTypeDao.findAll();
			return typeList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		
		
	}

}
