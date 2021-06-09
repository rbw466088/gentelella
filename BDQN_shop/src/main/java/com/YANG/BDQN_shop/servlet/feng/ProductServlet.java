package com.YANG.BDQN_shop.servlet.feng;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import com.YANG.BDQN_shop.domain.common.PageInfo;
import com.YANG.BDQN_shop.entity.feng.Product;
import com.YANG.BDQN_shop.service.feng.IProduct;


public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();

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
	
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		IProduct product=context.getBean("productService",IProduct.class);
		
		HttpSession session = request.getSession();
		//获取类型ID
		int id = Integer.parseInt(request.getParameter("id"));
		session.setAttribute("id", id);
		
		//查询对应商品id的总数
		//IProduct product=new ProductService();
		int count = product.getCount(id);
		
		//商品分页显示
		int page=1;
		String dangQianYe = request.getParameter("dangQianYe");
		if(dangQianYe==null || dangQianYe.equals("")){
			page=1;
		}else{
			page=Integer.parseInt(dangQianYe);
		}
		
		
		PageInfo<Product>  par = new PageInfo<Product>();
		par.setCounts(count);
		par.setDangQianYe(page);
		par.setShowCounts(8);
		int num = par.getDangQianYe()-1;
		num = num*par.getShowCounts();
		//System.out.println(num+"~~"+par.getDangQianYe()+"~~"+par.getShowCounts());
		List<Product> productList = product.findAllList(id,num, par.getShowCounts());
		request.setAttribute("productList", productList);
		request.setAttribute("par", par);
		request.getRequestDispatcher("/view/product-list.jsp").forward(request, response);
	}

}
