package com.gdglc.AjaxPro.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdglc.AjaxPro.entity.User;
import com.gdglc.AjaxPro.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userMap")
	private UserService userService ;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/zhuCe")
	public String showAdd() {
		return "ZhuCe";
	}
	
	@RequestMapping("/ajaxUserName")
	public void selectByName(String userName,HttpServletResponse response) {
		int num = 0;
		boolean data = false;
		PrintWriter out = null;
		try {
			out = response.getWriter();
			num = userService.selectByName(userName);
			if(num!=0) {
				data = true;
			}else {
				data = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			out.print(data);
			out.flush();
			out.close();
		}
	}
	
	@RequestMapping("/ajaxAddUser")
	public String insert(User user) {
		int num = 0;
		try {
			num = userService.insert(user);
			if(num!=0) {
				return "redirect:/game/showGames";
			}else {
				return "zhuCe";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "zhuCe";
		}
	}
	
	
	
	
	
	
}
