package com.yang.school.dao.impl;


import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.yang.school.dao.ClassInfoMapper;
import com.yang.school.entity.ClassInfo;

public class ClassInfoMapperImpl extends SqlSessionDaoSupport implements ClassInfoMapper {

//	private SqlSessionTemplate template ;
//	
//	public SqlSessionTemplate getTemplate() {
//		return template;
//	}
//
//	public void setTemplate(SqlSessionTemplate template) {
//		this.template = template;
//	}
	
	@Override
	public int findcount() {
		int num = this.getSqlSession().selectOne("com.yang.school.dao.ClassInfoMapper.findcount");
		return num;
	}

	@Override
	public void insert(ClassInfo info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ClassInfo> showClass() {
		// TODO Auto-generated method stub
		return null;
	}
	



}
