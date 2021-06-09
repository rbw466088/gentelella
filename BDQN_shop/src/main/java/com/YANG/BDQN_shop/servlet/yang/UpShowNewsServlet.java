package com.YANG.BDQN_shop.servlet.yang;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.entity.yang.News;
import com.YANG.BDQN_shop.service.yang.news.INewService;


@WebServlet("/UpShowNewsServlet")
public class UpShowNewsServlet extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
//		String resource = "myBatis-config.xml";
//		InputStream inputStream;
//		SqlSession session = null;
//		inputStream = Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		session = sqlSessionFactory.openSession();
//		
		HttpSession se = request.getSession();
		int enId = Integer.parseInt(request.getParameter("enId"));
		se.setAttribute("enId", enId);
//		INewDao newsDao = session.getMapper(INewDao.class);
		
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext) servletContext.getAttribute("context");
		INewService news = context.getBean("news",INewService.class); 
		
		List<News> newsList = news.getById(enId);
		request.setAttribute("newsList", newsList);
//		session.close();
		request.getRequestDispatcher("/manage/news-modify.jsp").forward(request, response);
	}

}
