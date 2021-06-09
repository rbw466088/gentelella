package com.gdglc.StuManagement.service;

import java.util.List;

import com.gdglc.StuManagement.entity.Classes;

public interface IClasses {
	
	/**
	 * 查询获取所有班级集合
	 * @return
	 */
	List<Classes> ShowClass();
}
