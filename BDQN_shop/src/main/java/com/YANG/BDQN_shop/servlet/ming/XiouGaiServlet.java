package com.YANG.BDQN_shop.servlet.ming;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.entity.ming.LiuYan;
import com.YANG.BDQN_shop.service.ming.IXiouGaiService;


public class XiouGaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext)servletContext.getAttribute("context");
		IXiouGaiService xiouGaiService=context.getBean("xiouGaiService",IXiouGaiService.class);
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		List<LiuYan> list = (List<LiuYan>)session.getAttribute("list");
		int id = list.get(0).getId();
		Date utilDate = new Date();	
		//用util 的 date.getTime()方法获取当前系统时间再转换为sql 的 Date
		java.sql.Date da = new java.sql.Date(utilDate.getTime()); 
		String reply = request.getParameter("replyContent");
		//IXiouGaiService xg=new XiouGaiServiceImpl();
		xiouGaiService.xiougai(reply, da, id);
		//request.getRequestDispatcher().forward(request, response);
		response.sendRedirect(path+"/manage/LiuYan");
		return;
	}

}
