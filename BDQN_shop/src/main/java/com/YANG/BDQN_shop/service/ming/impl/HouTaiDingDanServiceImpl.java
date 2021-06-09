package com.YANG.BDQN_shop.service.ming.impl;

import java.util.List;


import com.YANG.BDQN_shop.dao.ming.HouTaiDingDanDao;
import com.YANG.BDQN_shop.entity.ming.HouTaiDingDan;
import com.YANG.BDQN_shop.service.ming.IHouTaiDingDanService;

public class HouTaiDingDanServiceImpl implements IHouTaiDingDanService {

	private HouTaiDingDanDao houTaiDingDanDao;
	
	public HouTaiDingDanDao getHouTaiDingDanDao() {
		return houTaiDingDanDao;
	}

	public void setHouTaiDingDanDao(HouTaiDingDanDao houTaiDingDanDao) {
		this.houTaiDingDanDao = houTaiDingDanDao;
	}

	@Override
	public List<HouTaiDingDan> dingdan(HouTaiDingDan din) {
		/*String user = "myBatis-config.xml";
		InputStream input=null;
		SqlSessionFactory SqlSessionFactory = null;
		SqlSession sessions = null;
		IHouTaiDingDanService dao = null;
		List<HouTaiDingDan> dingDan = null;
		try {
			input = Resources.getResourceAsStream(user);
			SqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			sessions = SqlSessionFactory.openSession();   
			dao = sessions.getMapper(IHouTaiDingDanService.class);
			if(null!=din) {
				dingDan= dao.dingdan(din);
			}
			return dingDan;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sessions.close();
		}
		return dingDan;*/
		List<HouTaiDingDan> dingDan=houTaiDingDanDao.dingdan(din);
		return dingDan;
	}

	@Override
	public List<HouTaiDingDan> fiandDingdan(String name) {
		/*String user = "myBatis-config.xml";
		InputStream input=null;
		SqlSessionFactory SqlSessionFactory = null;
		SqlSession sessions = null;
		IHouTaiDingDanService dao = null;
		List<HouTaiDingDan> dingDan = null;
		try {
			input = Resources.getResourceAsStream(user);
			SqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			sessions = SqlSessionFactory.openSession();   
			dao = sessions.getMapper(IHouTaiDingDanService.class);
			if(null!=name) {
				dingDan= dao.fiandDingdan(name);
			}
			return dingDan;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sessions.close();
		}
		return dingDan;*/
		List<HouTaiDingDan>fiandDingdan=houTaiDingDanDao.fiandDingdan(name);
		return fiandDingdan;
	}

	@Override
	public List<HouTaiDingDan> userdingdan(HouTaiDingDan din) {
		/*String user = "myBatis-config.xml";
		InputStream input=null;
		SqlSessionFactory SqlSessionFactory = null;
		SqlSession sessions = null;
		IHouTaiDingDanService dao = null;
		List<HouTaiDingDan> dingDan = null;
		try {
			input = Resources.getResourceAsStream(user);
			SqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			sessions = SqlSessionFactory.openSession();   
			dao = sessions.getMapper(IHouTaiDingDanService.class);
			if(null!=din) {
				dingDan = dao.userdingdan(din);
			}
			return dingDan;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sessions.close();
		}
		return dingDan;*/
		List<HouTaiDingDan> userdingdan=houTaiDingDanDao.userdingdan(din);
		return userdingdan;
	}

}
