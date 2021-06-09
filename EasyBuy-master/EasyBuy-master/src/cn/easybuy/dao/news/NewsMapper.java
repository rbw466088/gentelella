package cn.easybuy.dao.news;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;

public interface NewsMapper {
	/**
	 * 根据id查询新闻
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public News getNewsById(@Param("id")Integer id)throws Exception; 
	/**
	 * 查询新闻列表
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<News> queryNewsList(NewsParams newsParams)throws Exception; 
	/**
	 * 查询新闻的数目
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int queryNewsCount(NewsParams newsParams)throws Exception;
}
