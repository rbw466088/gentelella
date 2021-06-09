package com.YANG.BDQN_shop.domain.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryUtil {
	 
private static SqlSessionFactory factory;
	
	static{  //在静态代码块下，factory只会被创建一次

		String resource = "myBatis-config.xml";
		InputStream inputStream;
		SqlSession session = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * true 为自动提交事务
	 * @return
	 */
	public static SqlSession createSqlSession(){
		return factory.openSession(true);			//true 为自动提交事务
	}
	
	
	
	
	
}
