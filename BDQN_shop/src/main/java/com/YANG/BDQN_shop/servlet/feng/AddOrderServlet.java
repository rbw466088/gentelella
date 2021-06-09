package com.YANG.BDQN_shop.servlet.feng;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.YANG.BDQN_shop.dao.feng.IOrderDao;
import com.YANG.BDQN_shop.dao.feng.IOrderDetailDao;

import com.YANG.BDQN_shop.entity.feng.Order;
import com.YANG.BDQN_shop.entity.feng.OrderDetail;
import com.YANG.BDQN_shop.entity.feng.Product;
import com.YANG.BDQN_shop.entity.you.LoginEntity;
import com.YANG.BDQN_shop.service.feng.IOrder;
import com.YANG.BDQN_shop.service.feng.IOrderDetail;
import com.YANG.BDQN_shop.service.feng.IProduct;
import com.YANG.BDQN_shop.service.feng.impl.OrderDetailService;
import com.YANG.BDQN_shop.service.feng.impl.OrderService;

public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		
		IOrder orders=context.getBean("orderService",IOrder.class);
		IOrderDetail orderDetails=context.getBean("orderDetailService",IOrderDetail.class);
		
		
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		
		LoginEntity inst = (LoginEntity)session.getAttribute("account");
		
		
		Date utilDate = new Date();	
		//用util 的 date.getTime()方法获取当前系统时间再转换为sql 的 Date
		java.sql.Date da = new java.sql.Date(utilDate.getTime());  
		
		
		String user=inst.getId();								//用户名
		
		String address=request.getParameter("address");			//用户地址ַ
		Float money=(Float)session.getAttribute("money");
		
		Float moneys=Float.parseFloat(request.getParameter("moneys"));
		
		//IOrder orderimpl=new OrderService();
		List<LoginEntity> list=orders.findAlls(user);
		
		Order order=null;
		if(null!=money){
			order=new Order(user,list.get(0).getName(),address, da,money,1,1);
		}else{
			order=new Order(user,list.get(0).getName(),address, da,moneys,1,1);
		}
		
		int result=orders.addOrder(order);
		
		if(result!=0){
			//添加订单详情信息
			
			int eoid=orders.finadOrder(inst.getId());
			Product product=(Product)request.getSession().getAttribute("productInfo");
			
			//System.out.println(eoid+"--"+product.getEpId()+"--"+product.getEpPrice());
			
			OrderDetail orderDetail=new OrderDetail(eoid,product.getEpId(),1,product.getEpPrice());
			
			//IOrderDetail orderDetailInfo=new OrderDetailService();
			orderDetails.addOrderDetail(orderDetail);
			
			
			response.sendRedirect(path+"/view/shopping-result.jsp");
			
		}else{
		
			session.setAttribute("message", "下单失败!请联系管理员!");
			response.sendRedirect(path+"/add.jsp");
		}
		
		
	}

}
