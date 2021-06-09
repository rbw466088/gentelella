package com.YANG.BDQN_shop.servlet.yang;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import com.YANG.BDQN_shop.service.yang.news.INewService;



public class UpdateNewsServlet extends HttpServlet {
	
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -6061523345201430410L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		//获取前台数据
		int enId = (int)session.getAttribute("enId");
		String enTitle = request.getParameter("title").toString();
		String enContent = request.getParameter("content").toString();
		
		Date utilDate = new Date();	
		java.sql.Date enCreateTime = new java.sql.Date(utilDate.getTime());
		
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext) servletContext.getAttribute("context");
		INewService news = context.getBean("news",INewService.class);
		news.updateNews(enTitle, enContent, enCreateTime, enId);
		response.sendRedirect(path+"/manage/infoNewsServlet");
		
	}

}
