package com.yang.school.service.test;

import java.util.List;

import com.yang.school.entity.ClassInfo;
import com.yang.school.exception.ServiceException;

public interface ITestService {
	
	List<ClassInfo> showClass();
	
	void insert(ClassInfo info) throws ServiceException;
}
