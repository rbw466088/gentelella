package com.gdglc.pets.servlet.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 532971857200755106L;
	
	public void init() {
		ServletContext servletContext = this.getServletContext();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/application.xml");
		servletContext.setAttribute("context", context);
		
		String path = servletContext.getContextPath();
		servletContext.setAttribute("path", path);
	}
	

}
