package com.gdglc.AjaxPro.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.gdglc.AjaxPro.entity.Game;


public interface GameService {
	
	/**
	 * 按条件查询游戏信息
	 * @return
	 */
	List<Game> showGame(@Param("name")String name,@Param("type")String type,
			@Param("company")String company,@Param("year")Integer year);
	
	/**
	 * 添加游戏信息
	 * @param record
	 * @return
	 */
	int insertSelective(Game record);
	
	/**
	 * 按ID删除游戏信息
	 * @param gameId
	 * @return
	 */
    int deleteByPrimaryKey(Integer gameId);
}
