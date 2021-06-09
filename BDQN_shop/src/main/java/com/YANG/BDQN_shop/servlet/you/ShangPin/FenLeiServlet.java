package com.YANG.BDQN_shop.servlet.you.ShangPin;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
import com.YANG.BDQN_shop.dao.you.IXiaoLeiDao;
import com.YANG.BDQN_shop.entity.you.DaLeiEntity;
import com.YANG.BDQN_shop.entity.you.XiaoLeiEntity;
import com.YANG.BDQN_shop.service.you.IDaLeiService;
import com.YANG.BDQN_shop.service.you.IDaLeiServiceImpl;
import com.YANG.BDQN_shop.service.you.IXiaoLeiServce;
import com.YANG.BDQN_shop.service.you.IXiaoLeiServceImpl;


public class FenLeiServlet extends HttpServlet {
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
		IDaLeiService dao=context.getBean("idaLeiServiceImpl",IDaLeiService.class);
		
		IXiaoLeiServce xiao=context.getBean("ixiaoLeiServceImpl",IXiaoLeiServce.class);
		
		List<DaLeiEntity> list=dao.findAlls();
		List<XiaoLeiEntity> lists=xiao.findAlls();//ֵ
		
		request.getSession().setAttribute("daLei", list);
		request.getSession().setAttribute("xiao", lists);
		request.getRequestDispatcher("/manage/product-add.jsp").forward(request, response);
	}

}
