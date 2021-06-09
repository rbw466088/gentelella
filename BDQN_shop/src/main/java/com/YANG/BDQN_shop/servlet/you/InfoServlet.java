package com.YANG.BDQN_shop.servlet.you;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.YANG.BDQN_shop.dao.you.ILoginDao;
import com.YANG.BDQN_shop.entity.you.LoginEntity;
import com.YANG.BDQN_shop.service.you.ILoginServlet;
import com.YANG.BDQN_shop.service.you.ILoginServletImpl;


public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		ILoginServlet dao=context.getBean("iloginServletImpl",ILoginServlet.class);
		try{
			String id =request.getParameter("id");
			LoginEntity login = dao.loginById(id);
			request.setAttribute("show",login);
			request.getRequestDispatcher("/manage/user-modify.jsp").forward(request, response);
			return;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
