package com.YANG.BDQN_shop.dao.feng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YANG.BDQN_shop.entity.feng.Product;

public interface IProductDao {
	/**
	 * 按父类ID分页显示商品
	 * @param epcId
	 * @param dangQianYe
	 * @param showCounts
	 * @return
	 */
	public List<Product> findAllList(@Param("epcId")int epcId,@Param("dangQianYe") int dangQianYe,@Param("showCounts")int showCounts);
	
	/**
	 * 按商品ID查询对应商品
	 * @param epId
	 * @return
	 */
	public Product findAll(int epId);
	
	/**
	 * 获取商品总数
	 * @param epcId
	 * @return
	 */
	public int getCount(int epcId);
	
	/**
	 * 获取所有的商品信息（分页管理）
	 * @return list集合
	 */
	public List<Product> getAll(@Param("dangQianYe")int dangQianYe,@Param("showCounts")int showCounts);
	
	/**
	 * 获取所有商品数量
	 * @return
	 */
	public int getCounts();
	
	
	
	
	
}
