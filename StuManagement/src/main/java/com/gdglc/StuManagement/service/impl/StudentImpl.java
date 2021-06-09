package com.gdglc.StuManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gdglc.StuManagement.dao.StudentMapper;
import com.gdglc.StuManagement.entity.Student;
import com.gdglc.StuManagement.service.IStudent;

public class StudentImpl implements IStudent {
	
	private StudentMapper studentMapper;
	
	public StudentMapper getStudentMapper() {
		return studentMapper;
	}

	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}


	@Override
	public List<Student> ShowStu() {
		List<Student> list = new ArrayList<Student>();
		try {
			list = studentMapper.ShowStu();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insert(Student record) {
		int num = 0;
		try {
			num = studentMapper.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

}
