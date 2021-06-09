package com.YANG.BDQN_shop.servlet.yang;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.service.yang.news.INewService;


@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


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
		String path = request.getContextPath();
		
		String enTitle = request.getParameter("title");
		String enContent = request.getParameter("content");
		Date utilDate = new Date();	
		java.sql.Date enCreateTime = new java.sql.Date(utilDate.getTime()); 
		
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext) servletContext.getAttribute("context");
		INewService news = context.getBean("news",INewService.class);
		news.addNews(enTitle, enContent, enCreateTime);
		response.sendRedirect(path+"/manage/infoNewsServlet");
		return;
	}

}
