package com.YANG.BDQN_shop.service.ming.impl;



import com.YANG.BDQN_shop.dao.ming.ShanChuDao;
import com.YANG.BDQN_shop.service.ming.IShanChuService;

public class ShanChuServiceImpl implements IShanChuService {

	private ShanChuDao shanChuDao;
	
	public ShanChuDao getShanChuDao() {
		return shanChuDao;
	}
	public void setShanChuDao(ShanChuDao shanChuDao) {
		this.shanChuDao = shanChuDao;
	}
	
	@Override
	public int shanchu(int id) {
		/*String user = "myBatis-config.xml";
		InputStream input=null;
		SqlSessionFactory SqlSessionFactory = null;
		SqlSession sessions = null;
		int sc=0;
		try {
			input = Resources.getResourceAsStream(user);
			SqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			sessions = SqlSessionFactory.openSession();   //自带事务true
			ShanChuDao dao = sessions.getMapper(ShanChuDao.class);
			sc =dao.shanchu(id);
			if(sc!=0) {
				sessions.commit();
			}else {
				sessions.rollback();
			}
			return sc;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sessions.close();
		}
		return sc;*/
		int sc = shanChuDao.shanchu(id);
		return sc;
	}

}
