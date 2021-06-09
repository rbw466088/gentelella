package com.YANG.BDQN_shop.servlet.ming;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.context.ApplicationContext;
import com.YANG.BDQN_shop.service.ming.IZhuCeService;




public class ZhuCeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

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
		IZhuCeService chaXunService=context.getBean("zhuCeService",IZhuCeService.class);
		
		String path = request.getContextPath();
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String confirmPassword = request.getParameter("confirmPassword");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String identityCode = request.getParameter("identityCode");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		//IZhuCeService biz=new ZhuCeServiceImpl();
		int zc = chaXunService.ZhuCe(userId,userName,confirmPassword,sex,birthday,identityCode,email,mobile,address);
		if(zc!=0){
			//session.setAttribute("message", "注册成功");
			//request.getRequestDispatcher("/regResult").forward(request, response);
			response.sendRedirect(path+"/regResult");
		}else{
			//session.setAttribute("message", "注册失败");
			request.getRequestDispatcher("/view/register.jsp").forward(request, response);
		}
	}

}
