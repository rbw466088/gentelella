package com.YANG.BDQN_shop.servlet.you.ShangPin;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.YANG.BDQN_shop.entity.you.EntitySpgl;
import com.YANG.BDQN_shop.service.you.IPerServlet;
import com.YANG.BDQN_shop.service.you.IPerServletImpl;
public class productDel extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	//商品的删除
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		IPerServlet dao=context.getBean("iperServletImpl",IPerServlet.class);
		EntitySpgl en=new EntitySpgl();
		en.setEpid(id);
		int re=dao.getSc(en);
		HttpSession session=request.getSession();
		if(re>0){
			session.setAttribute("prodel", "删除成功！");
			request.getRequestDispatcher("/manage/productList").forward(request, response);
		}
		else{
			session.setAttribute("prodel", "删除失败！");
			return;
		}
		
	}



}
