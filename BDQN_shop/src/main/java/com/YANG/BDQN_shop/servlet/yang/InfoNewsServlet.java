package com.YANG.BDQN_shop.servlet.yang;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.domain.common.PageInfo;
import com.YANG.BDQN_shop.entity.yang.News;
import com.YANG.BDQN_shop.service.yang.news.INewService;



@WebServlet("/InfoNewsServlet")
public class InfoNewsServlet extends HttpServlet {
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
		int page=1;
		String dangQianYe = request.getParameter("dangQianYe");
		if(dangQianYe==null || dangQianYe.equals("")){
			page=1;
		}else{
			page=Integer.parseInt(dangQianYe);
		}
		
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext) servletContext.getAttribute("context");
		INewService news = context.getBean("news",INewService.class);
		
		int count = news.getCount();
		PageInfo<News>  pas = new PageInfo<News>();
		pas.setCounts(count);
		pas.setDangQianYe(page);
		pas.setShowCounts(5);
		int id = pas.getDangQianYe();
		id = (id-1)*pas.getShowCounts();
		
		List<News> newslist = news.getInfoAll(id, pas.getShowCounts());
		request.setAttribute("newslist", newslist);
		request.setAttribute("pas", pas);
		
		request.getRequestDispatcher("/manage/manageNews").forward(request, response);
	}

}
