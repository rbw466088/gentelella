package com.YANG.BDQN_shop.service.ming.impl;

import java.util.List;


import com.YANG.BDQN_shop.dao.ming.ChaXunDao;
import com.YANG.BDQN_shop.entity.ming.LiuYan;
import com.YANG.BDQN_shop.service.ming.IChaXunService;

public class ChaXunServiceImpl implements IChaXunService {
	
	private ChaXunDao chaXunDao;
	
	public ChaXunDao getChaXunDao() {
		return chaXunDao;
	}

	public void setChaXunDao(ChaXunDao chaXunDao) {
		this.chaXunDao = chaXunDao;
	}


	@Override
	public List<LiuYan> cx(int id) {
		/*String user = "myBatis-config.xml";
		InputStream input=null;
//		SqlSessionFactory SqlSessionFactory = null;
		SqlSession sessions = null;   
		ChaXunDao dao =null;
		List<LiuYan> list = new ArrayList<LiuYan>();
		try {
			input = Resources.getResourceAsStream(user);
			SqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			sessions = SqlSessionFactory.openSession();
			dao = sessions.getMapper(ChaXunDao.class);
			list = dao.cx(id);
			sessions.commit();
			sessions.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;*/
		
		List<LiuYan> list=chaXunDao.cx(id);
		return list;
		
	}

}
