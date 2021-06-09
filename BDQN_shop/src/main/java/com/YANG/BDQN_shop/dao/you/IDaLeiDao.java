package com.YANG.BDQN_shop.dao.you;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YANG.BDQN_shop.entity.you.DaLeiEntity;

public interface IDaLeiDao {
	/**
	 * 查询ID值
	 * @param id
	 * @return
	 */
	public DaLeiEntity findById(@Param("id") int id);
	
	/**
	 * 查询数据
	 * @return
	 */
	public List<DaLeiEntity> findAlls();
	
	/**
	 * 修改数据
	 * @param das
	 * @return
	 */
	public int DaLeiUpdate(DaLeiEntity das);
	
	/**
	 * 添加数据
	 * @param info
	 * @return
	 */
	public int AddDaLei(DaLeiEntity info);
	
	/**
	 * 删除数据
	 * @param petId
	 * @return
	 */
	public int DeletDaLei(@Param("petId") int petId);
}
