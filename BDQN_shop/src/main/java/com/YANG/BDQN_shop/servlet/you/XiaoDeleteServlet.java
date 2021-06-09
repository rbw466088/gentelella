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

import com.YANG.BDQN_shop.dao.you.IXiaoLeiDao;
import com.YANG.BDQN_shop.service.you.IXiaoLeiServce;
import com.YANG.BDQN_shop.service.you.IXiaoLeiServceImpl;

public class XiaoDeleteServlet extends HttpServlet {
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
	//С���ɾ��
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String path=request.getContextPath(); 
		
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		IXiaoLeiServce xiao=context.getBean("ixiaoLeiServceImpl",IXiaoLeiServce.class);
		int petId = 0;
			petId=Integer.parseInt(request.getParameter("id"));
			int xiaoResul=xiao.DeletXiaos(petId);
			if(xiaoResul>0){
					session.setAttribute("delMessage", "ɾ���ɹ���");
					response.sendRedirect(path+"/manage/DaLeiServlet");
				
			}else{
				session.setAttribute("delMessage", "ɾ��ʧ�ܣ�");
				response.sendRedirect(path+"/manage/DaLeiServlet");
			}
	}

}
