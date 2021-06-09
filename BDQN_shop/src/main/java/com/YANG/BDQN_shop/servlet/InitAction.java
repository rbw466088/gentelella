package com.YANG.BDQN_shop.servlet;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Servlet implementation class InitAction
 */

public class InitAction extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8839501064371512096L;

	public void init() throws ServletException {
		ServletContext servletContext=getServletContext();
		String path=servletContext.getContextPath();
		servletContext.setAttribute("path", path);
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/application.xml");
		servletContext.setAttribute("context", context);
		
		
/*		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");*/
	}
	
}
