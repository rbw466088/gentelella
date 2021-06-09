package com.YANG.BDQN_shop.service.you;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YANG.BDQN_shop.entity.you.EntitySpgl;

public interface IPerServlet {

	/**
	 * 商品插入
	 * @param en
	 * @return
	 */
	public int getCr(EntitySpgl en);
	
	
	/**
	 * 商品管理删除
	 * @param en
	 * @return
	 */
	public int getSc(EntitySpgl en);
	
	
	/**
	 * 商品管理id查询
	 * @param id
	 * @return
	 */
	public EntitySpgl getIdcx(@Param("id")int id);
	
	/**
	 * 商品管理查询
	 * @return
	 */
	public List<EntitySpgl> getCx();
	
	
	/**
	 * 商品管理模糊查詢
	 * @param name
	 * @return
	 */
	public List<EntitySpgl> getMh(@Param("name")String name);
	
	
	/**
	 * 商品管理修改
	 * @param en
	 * @return
	 */
	public boolean getXg(EntitySpgl en);
}
