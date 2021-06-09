package com.YANG.BDQN_shop.service.you;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YANG.BDQN_shop.entity.you.XiaoLeiEntity;

public interface IXiaoLeiServce {
	/**
	 * 查询数据
	 * @return
	 */
	public List<XiaoLeiEntity> findAlls(); 
	
	/**
	 * 添加数据
	 * @param info
	 * @return
	 */
	public int AddXiaoLei(XiaoLeiEntity info);
	
	/**
	 * 删除数据
	 * @param papent
	 * @return
	 */
	public int DeletXiaoLei(@Param("papent") int papent);
	
	/**
	 * 删除数据
	 * @param petId
	 * @return
	 */
	public int DeletXiaos(@Param("petId") int petId);
	
	/**
	 * 查询ID值
	 * @param id
	 * @return
	 */
	public XiaoLeiEntity xiaoById(@Param("id") int id); //查询ID值ֵ
	
	/**
	 * 修改数据
	 * @param das
	 * @return
	 */
	public int XiaoLeiUpdate(XiaoLeiEntity das);
}
