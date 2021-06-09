package com.YANG.BDQN_shop.service.ming.impl;

import java.sql.Date;


import com.YANG.BDQN_shop.dao.ming.XiouGaiDao;
import com.YANG.BDQN_shop.service.ming.IXiouGaiService;

public class XiouGaiServiceImpl implements IXiouGaiService {

	private XiouGaiDao xiouGaiDao;
	
	public XiouGaiDao getXiouGaiDao() {
		return xiouGaiDao;
	}

	public void setXiouGaiDao(XiouGaiDao xiouGaiDao) {
		this.xiouGaiDao = xiouGaiDao;
	}

	@Override
	public int xiougai(String reply, Date time, int id) {
		/*String user = "myBatis-config.xml";
		InputStream input=null;
		SqlSessionFactory SqlSessionFactory = null;
		SqlSession sessions = null;
		try {
			input = Resources.getResourceAsStream(user);
			SqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			sessions = SqlSessionFactory.openSession();   
			XiouGaiDao dao= sessions.getMapper(XiouGaiDao.class);
			
			int num = dao.xiougai(reply,time,id);
			if(num!=0) {
				sessions.commit();
			}else {
				sessions.rollback();
			}
			sessions.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;*/
		
		int xg = xiouGaiDao.xiougai(reply, time, id);
		return xg;
	}

}
