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



public class UpdateServlet extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String path = request.getContextPath();
		
		
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		ILoginServlet dao=context.getBean("iloginServletImpl",ILoginServlet.class);
		
		String id=request.getParameter("userName");
		String name = request.getParameter("Names");
		String password = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String RiQi = request.getParameter("RiQi");
		String mobile =  request.getParameter("mobile");
		String address = request.getParameter("address");
		LoginEntity info=new LoginEntity(name,password,sex,RiQi,mobile,address);
		info.setId(id);
		int intlo=dao.update(info);
		//HttpSession session = request.getSession();
		request.setAttribute("HuoQu", id);
		//String user = (String)session.getAttribute("actions");
		if(intlo>0){
			//session.setAttribute("message", "�޸ĳɹ�");
			response.sendRedirect(path+"/manage/manage-result.jsp");
		}else{
			//session.setAttribute("message", "�޸�ʧ��");
			response.sendRedirect(path+"/manage/user-modify.jsp?petId="+id);
		}
	}

}
