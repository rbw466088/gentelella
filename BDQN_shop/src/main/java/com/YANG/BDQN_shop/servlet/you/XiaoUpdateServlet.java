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

import com.YANG.BDQN_shop.dao.you.IXiaoLeiDao;
import com.YANG.BDQN_shop.entity.you.XiaoLeiEntity;
import com.YANG.BDQN_shop.service.you.IXiaoLeiServce;
import com.YANG.BDQN_shop.service.you.IXiaoLeiServceImpl;

public class XiaoUpdateServlet extends HttpServlet {
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
		String path = request.getContextPath();
		
	
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		IXiaoLeiServce xiao=context.getBean("ixiaoLeiServceImpl",IXiaoLeiServce.class);                       
		
		String name = request.getParameter("Name");
		Integer id =  Integer.parseInt(request.getParameter("id"));
		XiaoLeiEntity dalei = new XiaoLeiEntity(name);
		dalei.setId(id);
		int result =xiao.XiaoLeiUpdate(dalei) ;
		//HttpSession session = request.getSession();
		if(result>0){
			//session.setAttribute("XiaoUpdateMessage", "�޸ĳɹ�");
			response.sendRedirect(path+"/manage/DaLeiServlet");
		}else{
			//session.setAttribute("XiaoUpdateMessage", "�޸�ʧ��");
			response.sendRedirect(path+"/manage/DaLeiServlet");
		}
	}

}
