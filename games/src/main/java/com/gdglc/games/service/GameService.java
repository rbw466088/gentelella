package com.gdglc.games.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gdglc.games.entity.Game;

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
}
