package com.gdglc.stuSystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import com.gdglc.stuSystem.service.IStandard;

/**
 * Servlet implementation class DeleteStandard
 */
public class DeleteStandard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStandard() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext)servletContext.getAttribute("context");
		IStandard standard = context.getBean("standard",IStandard.class);
		//获取删除条件的ID号
		String parameterValues = request.getParameter("id");
		String[] split = parameterValues.split(",");
		//调用删除方法
		List<String> id = new ArrayList<String>();
		if(parameterValues!=null) {
			for(int i=0;i<split.length;i++)
			 {
				 id.add(split[i]);
			 }
	        
	        int deleteByID = standard.deleteByID(id);
	        if(deleteByID!=0) {
	        	request.getSession().setAttribute("message", "删除成功");
	        }else {
	        	request.getSession().setAttribute("message", "删除失败");
	        }
		}
		
		response.sendRedirect(path+"/ShowStandard");
		return;
	}

}
