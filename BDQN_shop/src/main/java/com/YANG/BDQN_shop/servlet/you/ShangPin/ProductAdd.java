package com.YANG.BDQN_shop.servlet.you.ShangPin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.YANG.BDQN_shop.dao.you.IDaLeiDao;
import com.YANG.BDQN_shop.entity.you.EntitySpgl;
import com.YANG.BDQN_shop.service.you.IPerServlet;
import com.YANG.BDQN_shop.service.you.IPerServletImpl;
import com.YANG.BDQN_shop.service.you.IXiaoLeiServce;
public class ProductAdd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

//管理的添加
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	/*	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//String path=request.getContextPath();
		String productName=request.getParameter("productName");
		String productDetail=request.getParameter("productDetail");
		Integer parentId=Integer.parseInt(request.getParameter("parentId"));
		float productPrice=Float.parseFloat( request.getParameter("productPrice"));
		int productNumber=Integer.parseInt(request.getParameter("productNumber"));
		String photo=request.getParameter("photo");
		
		Daoimpl dao=new Daoimpl();
		EntitySpgl en=new EntitySpgl();
		en.setEP_NAME(productName);
		en.setEP_DESCRIPTION(productDetail);
		en.setEPC_ID(parentId);
		en.setEP_PRICE(productPrice);
		en.setEP_STOCK(productNumber);
		en.setEP_FILE_NAME(photo);
		int rs=dao.getCr(en);
		if(rs>0){
			request.getRequestDispatcher("/manage/productList").forward(request, response);
		}else{
			request.getRequestDispatcher("/manage/FenLeiServlet").forward(request, response);
		}*/
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取根目录
		String path = request.getContextPath();
		//文件名
		String fileName=null;
		
		ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		IPerServlet dao=context.getBean("iperServletImpl",IPerServlet.class);
		EntitySpgl pe = new EntitySpgl();
		List<Object> ls = new ArrayList<Object>();
		//获取绝对路径
		String realPath = request.getSession().getServletContext().getRealPath("/");  
		boolean multipartContent = ServletFileUpload.isMultipartContent(request);
		if(multipartContent) {
			DiskFileItemFactory disk = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(disk);
			upload.setHeaderEncoding("UTF-8");
			try {
				List<FileItem> list = upload.parseRequest(request);
				//FileItem item = parseRequest.get(5);
				for(int i=0;i<list.size();i++) {
					if(list.get(i).isFormField()) {
						ls.add(list.get(i).getString("utf-8"));
					}else {
						//获取文件名
						fileName = list.get(i).getName();
						fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
						ls.add(fileName);
						
						//File file = new File(realPath+"images/",,);
						//File file = new File("C:/Users/ljian/Desktop/Y2/BDQN_shop/WebContent/images/product/",fileName);
						File file = new File("J:/JSP_Path/BDQN_shop/WebContent/images/product/",fileName);
						list.get(i).write(file);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//获取二级种类编号
		pe.setEpname(ls.get(0).toString());
		pe.setEpdescription(ls.get(1).toString());
		pe.setEpcid(Integer.parseInt(ls.get(2).toString()));
		pe.setEpprice(Float.parseFloat(ls.get(3).toString()));
		pe.setEpstock(Integer.parseInt(ls.get(4).toString()));
		pe.setEpfilename(ls.get(5).toString());
		dao.getCr(pe);
		response.sendRedirect(path+"/manage/productList");
	}


}
