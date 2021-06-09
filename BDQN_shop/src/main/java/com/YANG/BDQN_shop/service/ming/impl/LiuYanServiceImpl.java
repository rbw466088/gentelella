package com.YANG.BDQN_shop.service.ming.impl;

import java.util.List;


import com.YANG.BDQN_shop.dao.ming.LiuYanDao;
import com.YANG.BDQN_shop.entity.ming.LiuYan;
import com.YANG.BDQN_shop.service.ming.ILiuYanService;

public class LiuYanServiceImpl implements ILiuYanService {

	private LiuYanDao liuYanDao;
	
	public LiuYanDao getLiuYanDao() {
		return liuYanDao;
	}

	public void setLiuYanDao(LiuYanDao liuYanDao) {
		this.liuYanDao = liuYanDao;
	}

	@Override
	public List<LiuYan> ly() {
		/*String user = "myBatis-config.xml";
		InputStream input =null;
		List<LiuYan> ly = null;
		SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		SqlSession sessions = SqlSessionFactory.openSession();   
		try {
			input = Resources.getResourceAsStream(user);
			LiuYanDao dao = sessions.getMapper(LiuYanDao.class);
			ly = dao.ly();
			return 	ly;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sessions.close();
		}
		return null;*/
		List<LiuYan>list=liuYanDao.ly();
		return list;
	}

}
