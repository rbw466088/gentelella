package com.yang.school.action.test;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.school.entity.ClassInfo;


@Controller
@RequestMapping("/test")
public class Test {
	
	//普通的转发
	@RequestMapping("/index")
	public String index(Model model) {
		System.out.println("测试test首页面");
		model.addAttribute("key", "广州广力分校");
		return "index"; 
	}
	@RequestMapping("/showInfo")
	public String showInfo(Model model,String name) {
		System.out.println("+++");
		model.addAttribute("name", name);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name", name);
//		mv.setViewName("/index");
//		System.out.println(mv);
		return  "index";
	}
	
	
	@RequestMapping("/show")
	public String showInfo(ClassInfo info) {
		System.out.println("输出：ID="+info.getId()+"  姓名="+info.getName());
		return "index";
	}
	
	//重定向
	@RequestMapping("/redirect")
	public String redirect() {
		System.out.println("========= redirect =============");
		return "redirect:/test/index";
	}
	
	//controller跳转到controller（则servlet跳转到servlet）也属于转发
	@RequestMapping("/forward")
	public String forward() {
		System.out.println("========= forward =============");
		return "forward:/test/redirect";
	}
}
