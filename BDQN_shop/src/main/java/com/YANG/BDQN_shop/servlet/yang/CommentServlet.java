package com.YANG.BDQN_shop.servlet.yang;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.domain.common.PageInfo;
import com.YANG.BDQN_shop.entity.yang.Comment;
import com.YANG.BDQN_shop.service.yang.comments.ICommentService;



public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int page=1;
		String dangQianYe = request.getParameter("dangQianYe");
		if(dangQianYe==null || dangQianYe.equals("")){
			page=1;
		}else{
			page=Integer.parseInt(dangQianYe);
		}
		
		//ICommentService comm = new CommentServiceImpl();
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext) servletContext.getAttribute("context");
		ICommentService comm = context.getBean("comment",ICommentService.class);
		int count = comm.getCount();
		PageInfo<Comment>  prs = new PageInfo<Comment>();
		prs.setCounts(count);
		prs.setDangQianYe(page);
		prs.setShowCounts(8);
		int id = prs.getDangQianYe();
		id = (id-1)*prs.getShowCounts();
		List<Comment> commentList = comm.getAll(id, prs.getShowCounts());
		request.setAttribute("commentList", commentList);
		request.setAttribute("prs", prs);
		
		request.getRequestDispatcher("/view/guestbook.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
