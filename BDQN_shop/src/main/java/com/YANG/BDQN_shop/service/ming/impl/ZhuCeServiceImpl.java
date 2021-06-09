package com.YANG.BDQN_shop.service.ming.impl;


import com.YANG.BDQN_shop.dao.ming.ZhuCeDao;
import com.YANG.BDQN_shop.service.ming.IZhuCeService;

public class ZhuCeServiceImpl implements IZhuCeService {
	
	private ZhuCeDao zhuCeDao;
	
	public ZhuCeDao getZhuCeDao() {
		return zhuCeDao;
	}

	public void setZhuCeDao(ZhuCeDao zhuCeDao) {
		this.zhuCeDao = zhuCeDao;
	}

	@Override
	public int ZhuCe(String id, String name, String password, String sex, String birthday, String identity,
			String email, String mobile, String address) {
		/*String user = "myBatis-config.xml";
		InputStream input=null;
		SqlSessionFactory SqlSessionFactory = null;
		SqlSession sessions = null;
		ZhuCeDao dao = null;
		int zc =0;
		try {
			input = Resources.getResourceAsStream(user);
			SqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			sessions = SqlSessionFactory.openSession();   
			dao = sessions.getMapper(ZhuCeDao.class);
			zc = dao.ZhuCe(id, name, password, sex, birthday, identity, email, mobile, address);
			if(zc!=0) {
				sessions.commit();
			}else {
				sessions.rollback();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sessions.close();
		}
		return zc;*/
		int zc = zhuCeDao.ZhuCe(id, name, password, sex, birthday, identity, email, mobile, address);
		return zc;
	}

}
