package com.YANG.BDQN_shop.servlet.you.ShangPin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.YANG.BDQN_shop.entity.you.EntitySpgl;
import com.YANG.BDQN_shop.service.you.IPerServlet;
import com.YANG.BDQN_shop.service.you.IPerServletImpl;

public class productUp extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	//商品的修改
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
    	String uploadFileName="";
    	String filedName="";
    	boolean isMultipart=ServletFileUpload.isMultipartContent(request);
    	//String uploadFilePath="D:/ACCP7.0 S2/tmpe/BDQN_shop/WebContent/images/product/";
    	String uploadFilePath="J:/JSP_Path/BDQN_shop/WebContent/images/product/";
    	out.print(uploadFilePath);
    	EntitySpgl en=new EntitySpgl();
    	if(isMultipart){
    		FileItemFactory factory=new DiskFileItemFactory();
    		ServletFileUpload upload=new ServletFileUpload(factory);
    		//实体类
    		try{
    			List<FileItem> items=upload.parseRequest(request);
    			Iterator<FileItem> iter=items.iterator();
    			while(iter.hasNext()){
    				FileItem item=(FileItem)iter.next();
    				if(item.isFormField()){
    					filedName=item.getFieldName();
    					if(filedName.equals("id")){
    						en.setEpid(Integer.parseInt(item.getString("utf-8")));
    					}
    					if(filedName.equals("productName")){
    						en.setEpname(item.getString("utf-8"));
    					}
    					if(filedName.equals("productms")){
    						en.setEpdescription(item.getString("utf-8"));
    					}
    					if(filedName.equals("parentId")){
    						en.setEpcid(Integer.parseInt(item.getString("utf-8")));
    					}
    					if(filedName.equals("productPrice")){
    						en.setEpprice(Float.parseFloat(item.getString("utf-8")));
    					}
    					if(filedName.equals("products")){
    						en.setEpstock(Integer.parseInt(item.getString("utf-8")));
    					}
    					if(filedName.equals("photo")){
    						en.setEpfilename((item.getString("utf-8")));
    					}
    				}else{
    					String fileName=item.getName();
    					if(fileName!=null && !fileName.equals("")){
    						File fullFile=new File(item.getName());
    						File saveFile=new File(uploadFilePath,fullFile.getName());
    						item.write(saveFile);
    						uploadFileName=fullFile.getName();
    						en.setEpfilename(saveFile.getName());
    					}
    				}
    			}
    		
    		}catch(Exception ex){
    			ex.printStackTrace();
    		}
    	}
    	
    	ServletContext servletContext=getServletContext();
		ApplicationContext context=(ApplicationContext)servletContext.getAttribute("context");
		IPerServlet da=context.getBean("iperServletImpl",IPerServlet.class);
    	boolean isOK=da.getXg(en);
    	
    	//HttpSession session=request.getSession();
    	if(isOK){
    		
    		request.getRequestDispatcher("/manage/productList").forward(request, response);
    	}
    	else{
    		request.getRequestDispatcher("/manage/productList").forward(request, response);
    		
    	}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
