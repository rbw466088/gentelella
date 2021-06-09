package com.gdglc.pets.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.gdglc.pets.entity.Pet;
import com.gdglc.pets.service.PetService;

/**
 * Servlet implementation class AddPetServlet
 */
public class AddPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPetServlet() {
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
		//获得biz接口对象
		PetService petService = (PetService)context.getBean("pets");
		
		//获取宠物昵称
		String petName = request.getParameter("petName");
		//获取宠物品种
		String petBreed = request.getParameter("petBreed");
		//获取宠物性别
		String petSex = request.getParameter("petSex");
		//获取宠物出生日期
		String birthdayStr = request.getParameter("birthday");
		Date date = new Date();
		//注意format的格式要与日期String的格式相匹配
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(birthdayStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//获宠物取描述
		String description = request.getParameter("description");
		
		Pet pet = new Pet();
		pet.setPetName(petName);
		pet.setPetBreed(petBreed);
		pet.setPetSex(petSex);
		pet.setBirthday(date);
		pet.setDescription(description);
		
		petService.insert(pet);
		response.sendRedirect(path+"/PetServlet");
		return;
	}

}
