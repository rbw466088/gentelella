package com.yang.school;


import java.io.UnsupportedEncodingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.school.dao.ClassInfoMapper;
import com.yang.school.entity.ClassInfo;
import com.yang.school.exception.ServiceException;
import com.yang.school.service.test.ITestService;

public class MybatisSpringTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
//		ClassInfoMapper infoMapper = context.getBean("testDaoOne",ClassInfoMapper.class);
//		int findcount = infoMapper.findcount();
//		System.out.println(findcount);
//		System.out.println("<==============================>");
//		ClassInfoMapper infoTwo = context.getBean("testDaoTwo",ClassInfoMapper.class);
//		int count = infoTwo.findcount();
//		System.out.println(count);
//		System.out.println("<==============================>");
		//getBean中的接口如果是两个大写字母开头就保持原样，如果是一个大写字母开头就第一个字母小写：classInfoMapper
//		ClassInfoMapper classInfoMapper = context.getBean("classInfoMapper",ClassInfoMapper.class);
//		int counts = classInfoMapper.findcount();
//		System.out.println(counts);
		
		
		ITestService testService = (ITestService)context.getBean("testService");
		ClassInfo classInfo = new ClassInfo();
		String orgName = "学士后Aa";
//		String cn_orgName = new String(orgName.getBytes("utf-8"),"utf-8");  
 
		classInfo.setName(orgName);
		try {
			testService.insert(classInfo);
		} catch (ServiceException e) {
			e.printStackTrace();
		}finally {
			System.out.println(classInfo.getName());
		}
	}
}
