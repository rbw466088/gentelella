package com.YANG.BDQN_shop.service.yang.comments;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.YANG.BDQN_shop.dao.yang.ICommentDao;
import com.YANG.BDQN_shop.entity.yang.Comment;

public class CommentServiceImpl implements ICommentService{
	//留言DAO接口对象，用来引用xml中的bean
	private ICommentDao commentDao;
	
	public ICommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}

	
	@Override
	public List<Comment> getAll(int dangQianYe, int showCounts) {
//		String resource = "myBatis-config.xml";
//		InputStream inputStream;
//		SqlSession session = null;
		List<Comment> commList = null;
		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			session = sqlSessionFactory.openSession();
//			//获取所有留言信息（分页显示）
//			ICommentDao comm = session.getMapper(ICommentDao.class);
//			commList = comm.getAll(dangQianYe, showCounts);
//			session.close();
			commList = commentDao.getAll(dangQianYe, showCounts);
			return commList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return commList;
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
//			//获取留言总数量
//			ICommentDao comm = session.getMapper(ICommentDao.class);
//			count = comm.getCount();
//			session.close();
			count = commentDao.getCount();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return count;
	}

	@Override
	public int addCom(String ecContent, Date ecCreateTime, String ecNickName) {
//		String resource = "myBatis-config.xml";
//		InputStream inputStream;
//		SqlSession session = null;
		int num = 0;
		try {
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			session = sqlSessionFactory.openSession();
			//调用添加留言方法
			if(null!=ecContent&&!"".equals(ecContent)&&null!=ecNickName&&!"".equals(ecNickName)) {
//				ICommentDao comm = session.getMapper(ICommentDao.class);
//				num = comm.addCom(ecContent, ecCreateTime, ecNickName);
				num = commentDao.addCom(ecContent, ecCreateTime, ecNickName);
//				if(num!=0) {
//					session.commit();
//				}else {
//					session.rollback();
//				}
			}
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			session.close();
		}
		return num;
	}

}
