package com.gdglc.StuManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gdglc.StuManagement.dao.ClassesMapper;
import com.gdglc.StuManagement.entity.Classes;
import com.gdglc.StuManagement.service.IClasses;

public class ClassImpl implements IClasses {
	
	private ClassesMapper classesMapper;

	public ClassesMapper getClassesMapper() {
		return classesMapper;
	}

	public void setClassesMapper(ClassesMapper classesMapper) {
		this.classesMapper = classesMapper;
	}

	@Override
	public List<Classes> ShowClass() {
		List<Classes> list = new ArrayList<Classes>();
		try {
			list = classesMapper.ShowClass();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
