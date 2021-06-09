package com.gdglc.pets.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.gdglc.pets.entity.Pet;
import com.gdglc.pets.service.PetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Servlet implementation class PetServlet
 */
public class PetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetServlet() {
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
		List<Pet> petList = new ArrayList<Pet>();
		//获得biz接口对象
		PetService petService = (PetService)context.getBean("pets");
		//获取品种
		String petBreed = request.getParameter("petBreed");

		if(null != petBreed&&!"".equals(petBreed)) {
			//调用按品种获取相应宠物信息方法
			petList = petService.selectPetByBreedListPage(petBreed);
		}else {
			//调用获取所有宠物信息方法
			petList = petService.selectPetListPage();
		}
		
		PageInfo<Pet> info = new PageInfo<Pet>(petList);

		request.setAttribute("info", info);
		request.setAttribute("petList", petList);
		request.getRequestDispatcher("/ShowPet.jsp").forward(request, response);
		return;
	}


}
