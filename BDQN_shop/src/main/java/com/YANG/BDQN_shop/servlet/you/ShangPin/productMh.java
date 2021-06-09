package com.YANG.BDQN_shop.servlet.you.ShangPin;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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

import com.YANG.BDQN_shop.dao.you.IDaLeiDao;
import com.YANG.BDQN_shop.entity.you.EntitySpgl;
import com.YANG.BDQN_shop.service.you.IPerServlet;
import com.YANG.BDQN_shop.service.you.IPerServletImpl;

public class productMh extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2677753944113536162L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String name=request.getParameter("name");
		
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		IPerServlet da=context.getBean("iperServletImpl",IPerServlet.class);
		List<EntitySpgl> en=da.getMh(name);
		
		if(en.size()>0){//商品的模糊查询
			request.getSession().setAttribute("proList", en);
			request.getRequestDispatcher("/manage/product.jsp").forward(request, response);
		}
		if(name==""){
			request.getRequestDispatcher("/manage/product.jsp").forward(request, response);
		}
		request.getSession().setAttribute("proList", en);
		request.getRequestDispatcher("/manage/product.jsp").forward(request, response);
	}

	

}
