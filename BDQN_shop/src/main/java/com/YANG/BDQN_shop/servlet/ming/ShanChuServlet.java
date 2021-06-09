package com.YANG.BDQN_shop.servlet.ming;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import com.YANG.BDQN_shop.service.ming.IShanChuService;




/**
 * Servlet implementation class ShanChuServlet
 */
public class ShanChuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShanChuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext)servletContext.getAttribute("context");
		IShanChuService shanChuService=context.getBean("shanChuService",IShanChuService.class);
		int id = Integer.parseInt(request.getParameter("id"));
		//IShanChuService scs=new ShanChuServiceImpl();
		int sc = shanChuService.shanchu(id);
		HttpSession session = request.getSession();
		if(sc!=0){
			session.setAttribute("message", "删除成功");
			request.getRequestDispatcher("LiuYan").forward(request, response);
		}else{
			session.setAttribute("message", "删除失败");
			request.getRequestDispatcher("LiuYan").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
