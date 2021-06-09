package com.gdglc.stuSystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gdglc.stuSystem.entity.Standard;

public interface IStandard {
	
	List<Standard> selectAll(@Param("name")String name);
	
	int deleteByID(List<String> id);
	
	int countByStdNum(String stdNum);
	
	int insert(Standard record);
	
    Standard selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKey(Standard record);
}
