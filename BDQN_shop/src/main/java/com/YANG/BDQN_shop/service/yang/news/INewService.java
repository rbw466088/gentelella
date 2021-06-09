package com.YANG.BDQN_shop.service.yang.news;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YANG.BDQN_shop.entity.yang.News;

public interface INewService {
	/**
	 * 获取所有的新闻信息
	 * @return list集合
	 */
	public List<News> getAll();
	
	/**
	 * 按ID获取相应的新闻信息
	 * @return list集合
	 */
	public List<News> getById(int newsID);
	
	/**
	 * 获取新闻总数量
	 * @return
	 */
	public int getCount();
	
	/**
	 * 获取所有的新闻信息（分页显示）
	 * @return list集合
	 */
	public List<News> getInfoAll(@Param("dangQianYe")int dangQianYe,@Param("showCounts")int showCounts);
	
	/**
	 * 添加新闻信息
	 * @param enTitle
	 * @param enContent
	 * @param enCreateTime
	 * @return
	 */
	public int addNews(@Param("enTitle")String enTitle,@Param("enContent")String enContent,@Param("enCreateTime")Date enCreateTime);

	/**
	 * 修改新闻信息
	 * @param enTitle
	 * @param enContent
	 * @param enCreateTime
	 * @param enId
	 * @return
	 */
	public int updateNews(@Param("enTitle")String enTitle,@Param("enContent")String enContent,@Param("enCreateTime")Date enCreateTime,@Param("enId")int enId);

	/**
	 * 删除相应新闻信息
	 * @param enId
	 * @return
	 */
	public int deleteNews(int enId);
}
