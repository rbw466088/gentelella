package com.YANG.BDQN_shop.servlet.ming;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.entity.ming.HouTaiDingDan;
import com.YANG.BDQN_shop.entity.you.LoginEntity;
import com.YANG.BDQN_shop.service.ming.IHouTaiDingDanService;

public class HouTaiDingDanSerevlet extends HttpServlet {
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
		IHouTaiDingDanService houTaiDingDanService = context.getBean("houTaiDingDanService",IHouTaiDingDanService.class);
		String ids=request.getParameter("entityId");
		String name=request.getParameter("userName");
		
		HttpSession session = request.getSession();
		LoginEntity inst = (LoginEntity)session.getAttribute("account");
		String userName = inst.getId();
		String actions = request.getParameter("actions");

		
		if(actions.equals("manage")){
			if((ids!=null&&!ids.equals(""))||(name!=null&&!name.equals(""))){
				String entityId = request.getParameter("entityId");
				Integer id = null;
				if(null!=entityId && !"".equals(entityId)) {
					id=Integer.parseInt(entityId);
				}
				HouTaiDingDan din = new HouTaiDingDan();
				din.setId(id);
				din.setNames(name);
				System.out.println(din.getId()+"---"+din.getNames());
				
				List<HouTaiDingDan> list = houTaiDingDanService.dingdan(din);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/manage/order.jsp").forward(request, response);
			}else{
				List<HouTaiDingDan> list = houTaiDingDanService.fiandDingdan(null);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/manage/order.jsp").forward(request, response);
			}
		}else if(actions.equals("user")){
			if(ids!=null&&!ids.equals("")){
				int id=Integer.parseInt(request.getParameter("entityId"));
				HouTaiDingDan din = new HouTaiDingDan();
				din.setId(id);
				din.setUserid(userName);
//				List<HouTaiDingDan> list = dao.userdingdan(din);
				List<HouTaiDingDan> list = houTaiDingDanService.userdingdan(din);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/manage/orderDetail.jsp").forward(request, response);
			}else{
				//System.out.println(userName+"~~~");
				//List<HouTaiDingDan> list = dao.fiandDingdan(userName);
				List<HouTaiDingDan> list = houTaiDingDanService.fiandDingdan(userName);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/manage/orderDetail.jsp").forward(request, response);
			}
		}

	}

}
