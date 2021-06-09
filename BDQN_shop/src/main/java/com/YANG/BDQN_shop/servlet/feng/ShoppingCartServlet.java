package com.YANG.BDQN_shop.servlet.feng;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.YANG.BDQN_shop.dao.feng.IProductDao;

import com.YANG.BDQN_shop.entity.feng.Product;
import com.YANG.BDQN_shop.entity.feng.ShopCar;
import com.YANG.BDQN_shop.entity.feng.ShopCarItem;
import com.YANG.BDQN_shop.entity.you.LoginEntity;
import com.YANG.BDQN_shop.service.feng.IOrder;
import com.YANG.BDQN_shop.service.feng.IProduct;
import com.YANG.BDQN_shop.service.feng.impl.OrderService;
import com.YANG.BDQN_shop.service.feng.impl.ProductService;


public class ShoppingCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1625112201286566025L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String action=request.getParameter("action");
		if(action.equals("show")){
			show(request, response);
		}else if(action.equals("add")){
			add(request,response);
		}else if(action.equals("remove")){
			remove(request, response);
		}else if(action.equals("delete")){
			delete(request, response);
		}
	}
	
	//显示商品信息
	public void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		ShopCar cart = (ShopCar) request.getSession().getAttribute("cart");
		if(request.getSession().getAttribute("cart") == null){
			cart = new ShopCar();
		}
		
		request.getSession().setAttribute("cart", cart);
		
		request.getRequestDispatcher("/view/shopping.jsp").forward(request, response);
		
		
	}
	
	//购物车商品数量增加1
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		IProduct product=context.getBean("productService",IProduct.class);
		//IProduct product=new ProductService();
		//IOrder order=new OrderService();
		IOrder order=context.getBean("orderService",IOrder.class);
		
		ShopCar cart = (ShopCar) request.getSession().getAttribute("cart");
		String id=request.getParameter("id");
		if(request.getSession().getAttribute("cart") == null){
			cart = new ShopCar();
		}
		boolean b = true;
		int epId = Integer.parseInt(request.getParameter("epId"));
		for(Map.Entry<String,ShopCarItem> map:cart.getItems().entrySet()){
			if(map.getKey().equals(String.valueOf(epId))){
				b = false;
				map.getValue().setCount(map.getValue().getCount()+1);
				break;
			}
			
		}
		if(b){
			
			Product productInfo = product.findAll(epId);
			cart.getItems().put(String.valueOf(epId), new ShopCarItem(productInfo,1));
		}
		request.getSession().setAttribute("cart", cart);
		if(id.equals("add")){
	
			Product productInfo = product.findAll(epId);
			request.getSession().setAttribute("productInfo", productInfo);
			request.getRequestDispatcher("/view/shopping.jsp").forward(request, response);
		}else if(id.equals("addes")){
			
			HttpSession session = request.getSession();
			LoginEntity inst = (LoginEntity)session.getAttribute("inst");
			String user=inst.getId();
			
			//获取用户ID信息（用来判断是普通用户还是管理员）
			List<LoginEntity> list=order.findAlls(user);
			
			Product productInfo = product.findAll(epId);
			
			request.getSession().setAttribute("productInfo", productInfo);
			request.getSession().setAttribute("listInfo", list);
			request.getRequestDispatcher("/view/address.jsp").forward(request, response);
		}
	}
	
	//删除购物车商品
	public void remove(HttpServletRequest request, HttpServletResponse response){
		String path=request.getContextPath();
		String id = request.getParameter("epId");
		ShopCar cart = (ShopCar) request.getSession().getAttribute("cart");
		Iterator<String> i=cart.getItems().keySet().iterator();
		while(i.hasNext()){
			String key=(String) i.next();
			if(key.equals(id)){
				i.remove();
				cart.removeItem(key);
			}
		}
		try {
			response.sendRedirect(path+"/view/shopping.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//购物车商品数量减1
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String id = request.getParameter("epId");
		ShopCar cart = (ShopCar) request.getSession().getAttribute("cart");
		for(Map.Entry<String,ShopCarItem> map:cart.getItems().entrySet()){
			if(map.getKey().equals(String.valueOf(id))){
				map.getValue().setCount(map.getValue().getCount()-1);
				break;
			}
		}
		try {
			request.getRequestDispatcher("/view/shopping.jsp").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
