package com.YANG.BDQN_shop.servlet.you;

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

import com.YANG.BDQN_shop.dao.you.ILoginDao;
import com.YANG.BDQN_shop.entity.you.LoginEntity;
import com.YANG.BDQN_shop.service.you.ILoginServlet;
import com.YANG.BDQN_shop.service.you.ILoginServletImpl;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.doPost(request, response);
		
		request.getRequestDispatcher("/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id=request.getParameter("userId");
		String pwd=request.getParameter("password");
		String path=request.getContextPath();
		
	
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		ILoginServlet dao=context.getBean("iloginServletImpl",ILoginServlet.class);
		
		LoginEntity info=new LoginEntity(id,pwd);
	
		LoginEntity inst=dao.findAll(info);
		
		HttpSession session = request.getSession();
		int num = dao.status(id, pwd);
		session.setAttribute("num", num);
		String action=request.getParameter("action");
		String code=(String)session.getAttribute("code");
		String yanZhengMa=request.getParameter("yanZhengMa");
		if(code.equalsIgnoreCase(yanZhengMa)){
			if(num==1){
				if(null!=action && !action.equals("")){
					session.setAttribute("account", inst);
					request.getRequestDispatcher("/view/product-view.jsp").forward(request, response);
					
				}else if(null!=inst){
					session.setAttribute("account", inst);
					request.getRequestDispatcher("/yangProduct").forward(request, response);
				}else{
					session.setAttribute("message", "��¼ʧ��");
					response.sendRedirect(path+"/login");
				}
			}else if(num==2){
				if(null!=inst){
					session.setAttribute("account", inst);
					//request.getRequestDispatcher("/manage").forward(request, response);
					response.sendRedirect(path+"/manage");
				}
				else{
					session.setAttribute("message", "��¼ʧ��");
					response.sendRedirect(path+"/login");
				}
			}
		}else{
			session.setAttribute("message", "��֤�����");
			response.sendRedirect(path+"/login");
		}
	}

}
