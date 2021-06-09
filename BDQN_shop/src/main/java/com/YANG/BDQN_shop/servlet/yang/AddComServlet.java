package com.YANG.BDQN_shop.servlet.yang;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.entity.you.LoginEntity;
import com.YANG.BDQN_shop.service.yang.comments.ICommentService;


/**
 * Servlet implementation class AddComServlet
 */
@WebServlet("/AddComServlet")
public class AddComServlet extends HttpServlet {
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
		String path = request.getContextPath();
		
		HttpSession session = request.getSession();
		String guestContent = request.getParameter("guestContent");
		LoginEntity inst = (LoginEntity)session.getAttribute("account");
		
		Date utilDate = new Date();	
		//用util 的 date.getTime()方法获取当前系统时间再转换为sql 的 Date
		java.sql.Date da = new java.sql.Date(utilDate.getTime());  
		
		if(null==inst){
			session.setAttribute("message", "请先登录！");
			response.sendRedirect(path+"/login");
			return;
		}else{
			String guestName = inst.getId();
//			ICommentService comm = new CommentServiceImpl();
			ServletContext servletContext = getServletContext();
			ApplicationContext context = (ApplicationContext) servletContext.getAttribute("context");
			ICommentService comm = context.getBean("comment",ICommentService.class);
			comm.addCom(guestContent, da, guestName);
			response.sendRedirect(path+"/commentServlet");
			return;
		}
	}

}
