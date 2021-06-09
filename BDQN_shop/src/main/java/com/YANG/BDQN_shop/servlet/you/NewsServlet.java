package com.YANG.BDQN_shop.servlet.you;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletConfig;
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


public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
        super();
       
    }

	

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
		
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		ILoginServlet dao=context.getBean("iloginServletImpl",ILoginServlet.class);
		
		HttpSession session = request.getSession();
		LoginEntity info = (LoginEntity)session.getAttribute("account");
		String id=info.getId();
		List<LoginEntity> in=dao.findAlls(id);
		session.setAttribute("newin", in);
		String actions=request.getParameter("actions");
    	session.setAttribute("actions",actions);
    	
		if(actions.equals("manage")){
			request.getRequestDispatcher("/manage/user.jsp").forward(request, response);
		}else if(actions.equals("user")){
			request.getRequestDispatcher("/manage/userInfo.jsp").forward(request, response);
		}
	}

}
