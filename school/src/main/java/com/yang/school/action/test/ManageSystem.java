package com.yang.school.action.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.school.entity.ClassInfo;
import com.yang.school.service.test.ITestService;

@Controller
@RequestMapping("/manage")
public class ManageSystem {
	
	@RequestMapping("/showClass")
	public String showClass(Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		ITestService test = context.getBean("classInfo",ITestService.class);
		List<ClassInfo> list = test.showClass();
		System.out.println(list.size());
		System.out.println("+++++++++++++++++++++++++");
		for (ClassInfo classInfo : list) {
			System.out.println("id:"+classInfo.getId());
			System.out.println("name:"+classInfo.getName());
		}
		model.addAttribute("list",list);
		return "showClass";
	}
	
	@RequestMapping("/addClass")
	public String addClass(String name) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		ITestService test = context.getBean("classInfo",ITestService.class);
		ClassInfo info = new ClassInfo();
		info.setName(name);
		try {
			test.insert(info);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/manage/addClass";
		}
		return "redirect:/manage/showClass";
	}
	
	@RequestMapping("/showInfo")
	public String showInfo(String name) {
		return "addClass";
	}
}
