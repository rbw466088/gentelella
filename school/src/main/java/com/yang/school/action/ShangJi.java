package com.yang.school.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ShangJi {
	
	@RequestMapping("/indexss")
	public String indexss() {
		return "indexss";
	}
	
	@RequestMapping("/ajaxEmail")
	public String ajaxEmail(String email,HttpServletResponse response) {
		String emailMap = "77962857@qq.com";
		boolean data = false;
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if(email.equals(emailMap)) {
				data = true;
			}else {
				data = false;
			}
			out.print(data);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "indexss";
	}
	
	@RequestMapping("/ajaxName")
	public String ajaxName(String name,HttpServletResponse response) {
		String nameMap = "779262857";
		boolean data = false;
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if(name.equals(nameMap)) {
				data = true;
			}else {
				data = false;
			}
			out.print(data);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "indexss";
	}
}
