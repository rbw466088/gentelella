package com.YANG.BDQN_shop.servlet.yang;

import java.io.IOException;
import java.io.InputStream;
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

import com.YANG.BDQN_shop.dao.yang.INewDao;
import com.YANG.BDQN_shop.domain.common.PageInfo;
import com.YANG.BDQN_shop.entity.feng.Category;
import com.YANG.BDQN_shop.entity.feng.Product;
import com.YANG.BDQN_shop.entity.feng.ProductType;
import com.YANG.BDQN_shop.entity.yang.News;
import com.YANG.BDQN_shop.exception.ServiceException;
import com.YANG.BDQN_shop.service.feng.ICategory;
import com.YANG.BDQN_shop.service.feng.IProduct;
import com.YANG.BDQN_shop.service.feng.IProductType;
import com.YANG.BDQN_shop.service.feng.impl.CategoryService;
import com.YANG.BDQN_shop.service.feng.impl.ProductService;
import com.YANG.BDQN_shop.service.feng.impl.ProductTypeService;
import com.YANG.BDQN_shop.service.yang.news.INewService;




public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int page=1;
		String dangQianYe = request.getParameter("dangQianYe");
		if(dangQianYe==null || dangQianYe.equals("")){
			page=1;
		}else{
			page=Integer.parseInt(dangQianYe);
		}
		
		
		//主页显示新闻信息
		INewService newService = context.getBean("news",INewService.class);
		List<News> newsList = newService.getAll();
		request.setAttribute("news", newsList);
		
		
		//显示全部商品信息
		IProduct product=context.getBean("productService",IProduct.class);
		
		//IProduct product=new ProductService();
		
		int count = product.getCounts();
		PageInfo<Product>  pr = new PageInfo<Product>();
		pr.setCounts(count);
		pr.setDangQianYe(page);
		pr.setShowCounts(8);
		int num = pr.getDangQianYe()-1;
		num = num*pr.getShowCounts();
		
		List<Product> productList = product.getAll(num, pr.getShowCounts());
		request.setAttribute("productList", productList);
		request.setAttribute("pr", pr);
		
		
		HttpSession sessions = request.getSession();
		
		//父分类
		
		//IProductType productType=new ProductTypeService();
		//List<ProductType> typeList=productType.findAll();
		
		IProductType productType=context.getBean("productTypeService",IProductType.class);
		List<ProductType> typeList=null;
		try {
			typeList = productType.findAll();
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
		sessions.setAttribute("typeList", typeList);
		
		
		
		//子分类
		//ICategory category=new CategoryService();
		//List<Category> categoryList=category.findAll();
		//sessions.setAttribute("categoryList", categoryList);
		
		ICategory category =context.getBean("categoryService",ICategory.class);
		List<Category> categoryList=null;
		try {
			categoryList = category.findAll();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		sessions.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("/view/index.jsp").forward(request, response);
	}

}
