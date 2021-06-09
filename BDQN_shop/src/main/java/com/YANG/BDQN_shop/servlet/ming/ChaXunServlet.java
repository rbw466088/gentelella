package com.YANG.BDQN_shop.servlet.ming;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.entity.ming.LiuYan;
import com.YANG.BDQN_shop.service.ming.IChaXunService;

/**
 * Servlet implementation class ChaXunServlet
 */
public class ChaXunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChaXunServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext)servletContext.getAttribute("context");
		IChaXunService chaXunService = context.getBean("chaXunService",IChaXunService.class);
		
		HttpSession session = request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		//IChaXunService biz=new ChaXunServiceImpl();
		List<LiuYan> list = chaXunService.cx(id);
		session.setAttribute("list", list);
		request.getRequestDispatcher("/manage/guestbook-modify.jsp").forward(request, response);
	}

}
