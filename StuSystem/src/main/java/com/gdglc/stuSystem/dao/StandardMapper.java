package com.gdglc.stuSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gdglc.stuSystem.entity.Standard;

public interface StandardMapper {
	
	/**
	 * 查询数据
	 * @param name
	 * @return
	 */
	List<Standard> selectAll(@Param("name")String name);
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	int deleteByID(@Param("IDlist")List<String> id);
	
	/**
	 * 查询是否有重复的标准号
	 * @param stdNum
	 * @return
	 */
	int countByStdNum(String stdNum);
    
	/**
	 * 新增数据
	 * @param record
	 * @return
	 */
    int insert(Standard record);

    int insertSelective(Standard record);
    
    /**
     * 按ID查找数据
     * @param id
     * @return
     */
    Standard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
}