package com.gdglc.AjaxPro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gdglc.AjaxPro.entity.Game;
import com.gdglc.AjaxPro.service.GameService;

@Controller
@RequestMapping("/game")
public class GamesController {
	
	@Resource(name="gameList")
	private GameService gameService;

	public GameService getGameService() {
		return gameService;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}
	
	@RequestMapping("/selectGames")
	public String selectGames() {
		return "SelectGames";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "AddGames";
	}
	
	@RequestMapping("/showGames")
	public String showGames(Game game,HttpServletRequest request) {
		return "ShowGames";
	}
	
	@RequestMapping("/getData")
	@ResponseBody
	public List<Game> getData(Game game,HttpServletRequest request,HttpServletResponse response){
		List<Game> gamesList = gameService.showGame(game.getGameName(), game.getGameType(), game.getGameCompany(), game.getGameYear());
		return gamesList;
/*		PrintWriter out = null;
		try {
			out = response.getWriter();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			String jsonString = JSON.toJSONString(gamesList);
			out.print(jsonString);
			out.flush();
			out.close();
		}*/
		
//		return "getData";
	}
	
	@RequestMapping("/addGames")
	@ResponseBody
	public boolean  addGames(Game game,HttpSession session) {
		int num = 0;
		num = gameService.insertSelective(game);
		if(num!=0) {
			return true;
		}else {
			session.setAttribute("message", "添加失败，请重试！");
			return false;
		}
	}
	
	@RequestMapping("/delGames")
	@ResponseBody
	public List<Game> delGames(Integer id) {
		List<Game> gamesList = new ArrayList<Game>();
		try {
			gameService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			gamesList = gameService.showGame(null, null, null, null);
			return gamesList;
		}
		gamesList = gameService.showGame(null, null, null, null);
		return gamesList;
		
	}
	
	
	
	
	
	
	
	
	
	
}
