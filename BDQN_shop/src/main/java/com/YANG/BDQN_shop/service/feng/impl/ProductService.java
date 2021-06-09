package com.YANG.BDQN_shop.service.feng.impl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.YANG.BDQN_shop.dao.feng.IProductDao;
import com.YANG.BDQN_shop.domain.common.FactoryUtil;
import com.YANG.BDQN_shop.entity.feng.Product;
import com.YANG.BDQN_shop.service.feng.IProduct;

public class ProductService implements IProduct {
	private IProductDao productDao;
	
	public IProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	
	SqlSession sqlsession=FactoryUtil.createSqlSession();
	
	@Override
	public List<Product> findAllList(int epcId, int dangQianYe, int showCounts) {
		//IProductDao productDao = sqlsession.getMapper(IProductDao.class);
		List<Product> productList = productDao.findAllList(epcId,dangQianYe, showCounts);
	
		return productList;
	}

	@Override
	public Product findAll(int epId) {
		//IProductDao productDao=sqlsession.getMapper(IProductDao.class);
		Product product=productDao.findAll(epId);
		
		return product;
	}

	@Override
	public int getCount(int epcId) {
		//IProductDao productDao = sqlsession.getMapper(IProductDao.class);
		return  productDao.getCount(epcId);
	}

	@Override
	public List<Product> getAll(int dangQianYe, int showCounts) {
		//IProductDao productDao = sqlsession.getMapper(IProductDao.class);
		List<Product> productList = productDao.getAll(dangQianYe, showCounts);
		
		return productList;
	}

	@Override
	public int getCounts() {
		//IProductDao productDao = sqlsession.getMapper(IProductDao.class);
		int count = productDao.getCounts();
		return count;
	}

}
