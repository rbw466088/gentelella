package com.gdglc.AjaxPro.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gdglc.AjaxPro.dao.GameMapper;
import com.gdglc.AjaxPro.entity.Game;
import com.gdglc.AjaxPro.service.GameService;


public class GameServiceImpl implements GameService {
	
	private GameMapper gameMapper;

	public GameMapper getGameMapper() {
		return gameMapper;
	}

	public void setGameMapper(GameMapper gameMapper) {
		this.gameMapper = gameMapper;
	}

	@Override
	public List<Game> showGame(String name, String type, String company, Integer year) {
		List<Game> gameList = new ArrayList<Game>();
		try {
			gameList = gameMapper.showGame(name, type, company, year);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gameList;
	}

	@Override
	public int insertSelective(Game record) {
		int num = 0;
		try {
			num = gameMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int deleteByPrimaryKey(Integer gameId) {
		int num = 0;
		try {
			num = gameMapper.deleteByPrimaryKey(gameId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

}
