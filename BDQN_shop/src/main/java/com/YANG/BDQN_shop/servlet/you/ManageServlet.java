package com.YANG.BDQN_shop.servlet.you;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/ManageServlet")
public  class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	int num=(int)session.getAttribute("num");
    	if(num==1){
    		request.getRequestDispatcher("/manage/userIndex.jsp").forward(request, response);
    	}else if(num==2){
    		request.getRequestDispatcher("/manage/index.jsp").forward(request, response);
    	}
	}
}
