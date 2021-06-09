package com.yang.school.dao;

import java.util.List;

import com.yang.school.entity.ClassInfo;

public interface ClassInfoMapper {
	int findcount();
	List<ClassInfo> showClass();
	void insert(ClassInfo info);
}