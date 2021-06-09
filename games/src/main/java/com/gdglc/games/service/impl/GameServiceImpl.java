package com.gdglc.games.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gdglc.games.dao.GameMapper;
import com.gdglc.games.entity.Game;
import com.gdglc.games.service.GameService;

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

}
