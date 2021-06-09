package com.gdglc.StuManagement.service;

import java.util.List;

import com.gdglc.StuManagement.entity.Student;

public interface IStudent {
	/**
	 *  查询所有学员信息
	 * @return
	 */
	List<Student> ShowStu();
	
	/**
	 * 添加数据
	 * @param record
	 * @return
	 */
    int insert(Student record);
}
