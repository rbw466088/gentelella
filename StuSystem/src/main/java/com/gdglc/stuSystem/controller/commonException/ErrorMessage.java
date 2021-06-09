package com.gdglc.stuSystem.controller.commonException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@ControllerAdvice
public class ErrorMessage {
	

//	@ExceptionHandler(Exception.class)
//	public String error(Exception e,HttpSession session) {
//		System.out.println("出现异常"+e.getMessage());
//		session.setAttribute("message", "上传文件超过限制！");
//		return "redirect:/standardInfo/add";
//	}
}
