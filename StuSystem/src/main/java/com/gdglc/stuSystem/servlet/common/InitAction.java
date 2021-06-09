package com.gdglc.stuSystem.servlet.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitAction extends HttpServlet {

	private static final long serialVersionUID = -3214093695331421024L;
	
	public void init() {
		ServletContext servletContext = getServletContext();
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring/application.xml");
//		servletContext.setAttribute("context", context);
		String path = servletContext.getContextPath();
		servletContext.setAttribute("path", path);
	}
	
}
