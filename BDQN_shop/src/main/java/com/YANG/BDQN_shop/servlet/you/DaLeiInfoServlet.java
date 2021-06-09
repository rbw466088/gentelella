package com.YANG.BDQN_shop.servlet.you;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.entity.you.DaLeiEntity;
import com.YANG.BDQN_shop.service.you.IDaLeiService;



public class DaLeiInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DaLeiInfoServlet() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	/*public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}*/



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//request.getServletContext();
		
		ServletContext servletContext=getServletContext();
		System.out.println("sfsf"+servletContext);
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		IDaLeiService dao=context.getBean("idaLeiServiceImpl",IDaLeiService.class);
		try{
			int id =  Integer.parseInt(request.getParameter("id"));
			DaLeiEntity da = dao.findById(id);
			request.getSession().setAttribute("dainfo", da);
			request.getRequestDispatcher("/manage/productClass-modify.jsp").forward(request,response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
