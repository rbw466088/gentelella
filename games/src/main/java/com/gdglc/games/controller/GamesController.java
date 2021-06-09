package com.gdglc.games.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdglc.games.entity.Game;
import com.gdglc.games.service.GameService;

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
	public String showGames(Game game,Model model) {
		List<Game> gamesList = gameService.showGame(game.getGameName(), game.getGameType(), game.getGameCompany(), game.getGameYear());
		if(gamesList.size()>0) {
			model.addAttribute("list", gamesList);
		}else {
			model.addAttribute("messJoin", "没有查询到你要找的游戏！");
		}
		return "ShowGames";
	}
	
	@RequestMapping("/addGames")
	public String  addGames(Game game,HttpSession session) {
		int num = 0;
		num = gameService.insertSelective(game);
		if(num!=0) {
			session.setAttribute("message", "添加成功！");
//			model.addAttribute("message", "添加成功！");
			return "redirect:/game/showGames";
		}else {
			session.setAttribute("message", "添加失败，请重试！");
//			model.addAttribute("message", "添加失败，请重试！");
			return "forward:add";
		}
		
	}
}
