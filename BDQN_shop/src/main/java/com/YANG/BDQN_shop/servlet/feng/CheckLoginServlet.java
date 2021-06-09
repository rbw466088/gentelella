package com.YANG.BDQN_shop.servlet.feng;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YANG.BDQN_shop.entity.you.LoginEntity;


public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginServlet() {
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
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		LoginEntity inst = (LoginEntity)session.getAttribute("account");
		Integer epid=Integer.parseInt(request.getParameter("epid"));
		String action=request.getParameter("action");
		session.setAttribute("action", action);
		if(null==inst||"".equals(inst)){
			
			response.sendRedirect(path+"/view/login.jsp");
			return;
		}else{
			session.setAttribute("inst", inst);
			if(action.equals("jr")){
				request.getRequestDispatcher("/shoppingCart?action=add&id=add&epId="+epid).forward(request, response);
			}else if(action.equals("js")){
				request.getRequestDispatcher("/shoppingCart?action=add&id=addes&epId="+epid).forward(request, response);
			}
		}
	}

}
