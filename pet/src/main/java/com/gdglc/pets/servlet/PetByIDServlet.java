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

/**
 * Servlet implementation class PetByID
 */
public class PetByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetByIDServlet() {
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
		
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext)servletContext.getAttribute("context");
		List<Pet> petList = new ArrayList<Pet>();
		//获得biz接口对象
		PetService petService = (PetService)context.getBean("pets");
		
		//页面获取ID
		Integer petId = Integer.parseInt(request.getParameter("petId"));
		//调用按ID查询数据
		petList = petService.selectPetByID(petId);
		request.setAttribute("petList", petList);
		request.getRequestDispatcher("/UpdatePet.jsp").forward(request, response);
		return;
	}

	
	
	
}
