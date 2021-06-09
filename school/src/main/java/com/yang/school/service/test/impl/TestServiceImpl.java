 package com.yang.school.service.test.impl;

import java.util.ArrayList;
import java.util.List;

import com.yang.school.dao.ClassInfoMapper;
import com.yang.school.entity.ClassInfo;
import com.yang.school.exception.ServiceException;
import com.yang.school.service.test.ITestService;

public class TestServiceImpl implements ITestService {
	private ClassInfoMapper classInfo;
	
	public ClassInfoMapper getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfoMapper classInfo) {
		this.classInfo = classInfo;
	}

	@Override
	public void insert(ClassInfo info) throws ServiceException{
		System.out.println("判断");
		try {
			classInfo.insert(info);
		} catch (Exception e) {
			throw new ServiceException("添加失败",e);
		}
		//出现异常
//		if(1==1) {
//			//throw new ServiceException("模拟出现异常,测试事务");
//		}
	}

	@Override
	public List<ClassInfo> showClass() {
		List<ClassInfo> list = new ArrayList<ClassInfo>();
		try {
			list= classInfo.showClass();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
