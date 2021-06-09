package com.YANG.BDQN_shop.servlet.ming;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.entity.ming.LiuYan;
import com.YANG.BDQN_shop.service.ming.ILiuYanService;

/**
 * Servlet implementation class LiuYanServlet
 */
public class LiuYanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LiuYanServlet() {
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
		ILiuYanService liuYanService=context.getBean("liuYanService",ILiuYanService.class);

		//ILiuYanService ly=new LiuYanServiceImpl();
		List<LiuYan> lylist = liuYanService.ly();
		request.setAttribute("list", lylist);

		request.getRequestDispatcher("/manage/guestbook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
