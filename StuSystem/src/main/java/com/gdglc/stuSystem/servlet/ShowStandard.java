package com.gdglc.stuSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.gdglc.stuSystem.entity.Standard;
import com.gdglc.stuSystem.service.IStandard;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Servlet implementation class ShowStandard
 */
public class ShowStandard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStandard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//分页显示
		int pageNum = 1;
		String dangQianYe = request.getParameter("pageNum");
		if(dangQianYe==null || dangQianYe.equals("")){
			pageNum = 1;
		}else{
			pageNum = Integer.parseInt(dangQianYe);
		}
		//设置分页，必须在获取数据之前注入
		PageHelper.startPage(pageNum,2);
		
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext)servletContext.getAttribute("context");
		IStandard standard = context.getBean("standard",IStandard.class);
		
		//获取查询条件
		String zhname = request.getParameter("zhname");
		request.setAttribute("zhname", zhname);
		List<Standard> standardList = standard.selectAll(zhname);
		
		PageInfo<Standard> info = new PageInfo<Standard>(standardList);
		
		request.setAttribute("info", info);
		request.setAttribute("standardList", standardList);
		request.getRequestDispatcher("/ShowStandard.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
