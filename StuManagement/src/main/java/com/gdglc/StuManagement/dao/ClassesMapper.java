package com.gdglc.StuManagement.dao;

import java.util.List;

import com.gdglc.StuManagement.entity.Classes;

public interface ClassesMapper {
	
	/**
	 * 查询获取所有班级集合
	 * @return
	 */
	List<Classes> ShowClass();
	
    int deleteByPrimaryKey(Integer id);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}