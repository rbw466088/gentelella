package cn.easybuy.service.news;

import java.util.List;

import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.Pager;

public interface NewsService{
	
	/**
	 * 根据id查询新闻
	 * @param parameter
	 * @return
	 */
	public News findNewsById(String parameter);
	
	/***
	 * 查询新闻列表
	 * @param param
	 * @return
	 */
	public List<News> queryNewsList(NewsParams param);
	/***
	 * 查询数目
	 * @param param
	 * @return
	 */
	public Integer queryNewsCount(NewsParams param);

}
