package com.YANG.BDQN_shop.servlet.yang;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.entity.yang.News;
import com.YANG.BDQN_shop.service.yang.news.INewService;


public class NewsServlet extends HttpServlet {
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
		
		int newsId = Integer.parseInt(request.getParameter("newsId")); 
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext) servletContext.getAttribute("context");
		INewService news = context.getBean("news",INewService.class);
		List<News> list = news.getById(newsId);
		request.setAttribute("byIdList", list);
		
		request.getRequestDispatcher("/view/news-view.jsp").forward(request, response);
	}

}
