package com.YANG.BDQN_shop.service.yang.news;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.YANG.BDQN_shop.dao.yang.INewDao;
import com.YANG.BDQN_shop.entity.yang.News;

public class NewServiceImpl implements INewService {
	//新闻DAO接口对象，用来引用xml中的bean
	private INewDao newDao;

	public INewDao getNewDao() {
		return newDao;
	}

	public void setNewDao(INewDao newDao) {
		this.newDao = newDao;
	}

	@Override
	public List<News> getAll() {
//		String resource = "myBatis-config.xml";
//		InputStream inputStream;
//		SqlSession session = null;
		List<News> newsList = null;
		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			session = sqlSessionFactory.openSession();
//			//主页显示新闻信息
//			INewDao newsDao = session.getMapper(INewDao.class);  //调用getMapper创建对应的接口对象
//			newsList = newsDao.getAll();
//			session.close();
			newsList = newDao.getAll();
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return newsList;
	}

	@Override
	public List<News> getById(int newsID) {
//		String resource = "myBatis-config.xml";
//		InputStream inputStream;
//		SqlSession session = null;
		List<News> newsList = null;
		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			session = sqlSessionFactory.openSession();
//			//按ID查询相应新闻
//			INewDao newsDao = session.getMapper(INewDao.class); 
//			newsList = newsDao.getById(newsID);
//			session.close();
			newsList = newDao.getById(newsID);
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return newsList;
	}

	@Override
	public int getCount() {
//		String resource = "myBatis-config.xml";
//		InputStream inputStream;
//		SqlSession session = null;
		int count = 0;
		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			session = sqlSessionFactory.openSession();
//			//获取新闻总数量
//			INewDao newsDao = session.getMapper(INewDao.class);
//			count = newsDao.getCount();
//			session.close();
			count = newDao.getCount();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return count;
	}

	@Override
	public List<News> getInfoAll(int dangQianYe, int showCounts) {
//		String resource = "myBatis-config.xml";
//		InputStream inputStream;
//		SqlSession session = null;
		List<News> newsList = null;
		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			session = sqlSessionFactory.openSession();
//			//按分页显示新闻信息
//			INewDao newsDao = session.getMapper(INewDao.class); 
//			newsList = newsDao.getInfoAll(dangQianYe, showCounts);
//			session.close();
			newsList = newDao.getInfoAll(dangQianYe, showCounts);
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return newsList;
	}

	@Override
	public int addNews(String enTitle, String enContent, Date enCreateTime) {
//		String resource = "myBatis-config.xml";
//		InputStream inputStream;
//		SqlSession session = null;
		int num = 0; 
		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			session = sqlSessionFactory.openSession();
			if(null!=enTitle&&!"".equals(enTitle)&&null!=enContent&&!"".equals(enContent)) {
				//输入的标题和内容都不为空则调用DAO的添加方法
//				INewDao newsDao = session.getMapper(INewDao.class);
//				num = newsDao.addNews(enTitle, enContent, enCreateTime);
//				if(num!=0) {
//					session.commit();
//					session.close();
//					return num;
//				}else {
//					session.rollback();
//				}
				num = newDao.addNews(enTitle, enContent, enCreateTime);
			}
		} catch (Exception e) {
			e.printStackTrace();
//			session.rollback();
//			session.close();
		}finally {
//			session.close();
		}
		return num;
	}


	@Override
	public int updateNews(String enTitle, String enContent, Date enCreateTime, int enId) {
//		String resource = "myBatis-config.xml";
//		InputStream inputStream;
//		SqlSession session = null;
		int num = 0;
		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			session = sqlSessionFactory.openSession();
//			//输入的标题和内容都不为空则调用DAO的修改方法
//			INewDao newsDao = session.getMapper(INewDao.class);
			if(null!=enTitle&&!"".equals(enTitle)&&null!=enContent&&!"".equals(enContent)) {
//				num = newsDao.updateNews(enTitle, enContent, enCreateTime, enId);
//				if(num!=0) {
//					session.commit();
//					session.close();
//				}else {
//					session.rollback();
//				}
				num = newDao.updateNews(enTitle, enContent, enCreateTime, enId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return num;
	}

	@Override
	public int deleteNews(int enId) {
//		String resource = "myBatis-config.xml";
//		InputStream inputStream;
//		SqlSession session = null;
		int num = 0;
		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			session = sqlSessionFactory.openSession();
//			//调用DAO的删除方法
//			INewDao newsDao = session.getMapper(INewDao.class);
//			num = newsDao.deleteNews(enId);
//			if(num!=0) {
//				session.commit();
//				session.close();
//			}else {
//				session.rollback();
//			}
			num = newDao.deleteNews(enId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return num;
	}

}
