package cn.easybuy.service.news;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.easybuy.dao.news.NewsDao;
import cn.easybuy.dao.news.NewsDaoImpl;
import cn.easybuy.dao.news.NewsMapper;
import cn.easybuy.dao.product.ProductCategoryMapper;
import cn.easybuy.entity.News;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.MyBatisUtil;
import cn.easybuy.utils.Pager;
import cn.easybuy.utils.Params;

/**
 *
 */
public class NewsServiceImpl implements NewsService {

	public News findNewsById(String id) {// 根据ID获取新闻
		SqlSession sqlSession = null;
		News news = new News();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			news = sqlSession.getMapper(NewsMapper.class).getNewsById(Integer.parseInt(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			news = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return news;
	}
	
	@Override
	public List<News> queryNewsList(NewsParams param) {
		SqlSession sqlSession = null;
		List<News> newsList = new ArrayList<News>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			newsList = sqlSession.getMapper(NewsMapper.class).queryNewsList(param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			newsList = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return newsList;
	}

	/**
	 * 查看新闻数目
	 */
	@Override
	public Integer queryNewsCount(NewsParams param) {
		SqlSession sqlSession = null;
		Integer count=0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			count = sqlSession.getMapper(NewsMapper.class).queryNewsCount(param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			count = 0;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return count;
	}

}
