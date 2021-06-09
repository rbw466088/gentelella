package com.gdglc.pets.servlet;

import java.io.IOException;
import java.text.DateFormat;
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
 * Servlet implementation class UpdatePetServlet
 */
public class UpdatePetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePetServlet() {
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
		
		//从页面获取信息
		int petId = Integer.parseInt(request.getParameter("petId"));	//获取宠物ID
		String petName = request.getParameter("petName");				//获取宠物昵称
		String petBreed = request.getParameter("petBreed");				//获取宠物品种
		String petSex = request.getParameter("petSex");					//获取宠物性别
		String birthdayStr = request.getParameter("birthday");			//获取宠物出生日期
		Date date = new Date();   
        //注意format的格式要与日期String的格式相匹配   
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
        try {   
            date = sdf.parse(birthdayStr);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
		String description = request.getParameter("description");		//获取宠物描述
		//把数据信息写进实体类
		Pet pet = new Pet();
		pet.setPetId(petId);
		pet.setPetName(petName);
		pet.setPetBreed(petBreed);
		pet.setPetSex(petSex);
		pet.setBirthday(date);
		pet.setDescription(description);
		//调用更新方法
		petService.updateByPrimaryKey(pet);
		response.sendRedirect(path+"/PetServlet");
		return;
	}

}
