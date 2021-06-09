package com.YANG.BDQN_shop.servlet.feng;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

import com.YANG.BDQN_shop.dao.feng.IProductDao;
import com.YANG.BDQN_shop.entity.feng.Product;
import com.YANG.BDQN_shop.service.feng.IProduct;
import com.YANG.BDQN_shop.service.feng.impl.ProductService;




public class ProductViewServlet extends HttpServlet {
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
		
		
		List<Product> products = (List<Product>)request.getSession().getAttribute("productsInfo");
		if(request.getSession().getAttribute("productsInfo") == null){
			products = new ArrayList<Product>();
		}
		
		//获取商品的编号
		int epid=Integer.parseInt(request.getParameter("epid"));
		//根据商品id获取商品的信息
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		IProduct product=context.getBean("productService",IProduct.class);
		//IProduct product=new ProductService();
		Product productInfo=product.findAll(epid);
		
		
		boolean isOK = true;
		for(int i = 0; i < products.size(); i++){
			if(productInfo.getEpId() == products.get(i).getEpId()){
				isOK = false;
				break;
			}
		}
		if(isOK){
			products.add(0, productInfo);
		}
		if(products.size() == 5){
			products.remove(4);
		}
		request.getSession().setAttribute("productsInfo", products);
	
		HttpSession sessions = request.getSession();
		sessions.setAttribute("info", productInfo);
		request.getRequestDispatcher("/view/product-view.jsp").forward(request, response);
	}

}
