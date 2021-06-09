package com.gdglc.stuSystem.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.context.ApplicationContext;

import com.gdglc.stuSystem.entity.Standard;
import com.gdglc.stuSystem.service.IStandard;

/**
 * Servlet implementation class AddStandard
 */
public class AddStandard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 内存临界值 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 最大文件上传值 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 最大请求值 50MB
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStandard() {
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
		
		//获取接口对象
		ServletContext servletContext = getServletContext();
		ApplicationContext context = (ApplicationContext)servletContext.getAttribute("context");
		IStandard standard = context.getBean("standard",IStandard.class);
		
		//文件上传
		// 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8"); 
		
        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
       
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
		//定义参数，用来获取前台数据
		String stdNum = null;
		String zhname = null;
		String version = null;
		String keys = null;
		String releaseDate = null;
		String implDate = null;
		
        String fileName = null;		//文件名
        String newFileName = null;	//新的文件名（用于插入数据库不会有重复的文件名）
        String filePath = null;		//文件全路径（保存到数据库的文件全路径）
        try {
            // 解析请求的内容提取文件数据
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        fileName = new File(item.getName()).getName();
                        System.out.println("原文件名："+fileName);
                        newFileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+".jpg";
                        System.out.println("新文件名："+newFileName);
                        filePath = uploadPath + File.separator + newFileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        
                        //request.setAttribute("message","文件上传成功!");
                    }
                    if(item.getFieldName().equals("stdNum")) {
                    	stdNum = item.getString("UTF-8");
                		System.out.println(stdNum);
                    }
                    if(item.getFieldName().equals("zhname")) {
                    	zhname = item.getString("UTF-8");
                		System.out.println(zhname);
                    }
                    if(item.getFieldName().equals("version")) {
                    	version = item.getString("UTF-8");
                		System.out.println(version);
                    }
                    if(item.getFieldName().equals("keys")) {
                    	keys = item.getString("UTF-8");
                		System.out.println(keys);
                    }
                    if(item.getFieldName().equals("releaseDate")) {
                    	releaseDate = item.getString("UTF-8");
                		System.out.println(releaseDate);
                    }
                    if(item.getFieldName().equals("implDate")) {
                    	implDate = item.getString("UTF-8");
                		System.out.println(implDate);
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message","错误信息: " + ex.getMessage());
        }
        
        //把String类型转换为Date类型
        Date relDate = new Date(); 
		Date impDate = new Date(); 
        //注意format的格式要与日期String的格式相匹配   
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
        try {   
        	relDate = sdf.parse(releaseDate);   
        	impDate = sdf.parse(implDate);   
        } catch (Exception e) {   
            //e.printStackTrace();
            relDate = null;
            impDate = null;
        }  
		//按标准号获取数量，用作验证是否有重复标准号
		int byStdNum = standard.countByStdNum(stdNum);
		if(byStdNum!=0) {
			//有重复数据
			request.getSession().setAttribute("message", "标准号重复！");
			response.sendRedirect(path+"/AddStandard.jsp");
			return;
		}else {
			//没有重复则新增数据
			Standard stan = new Standard(stdNum, zhname, version, keys, relDate, impDate, filePath);
			int num = standard.insert(stan);
			if(num!=0) {
				request.getSession().setAttribute("message", "新增成功！");
				response.sendRedirect(path+"/ShowStandard");
				return;
			}else {
				request.getSession().setAttribute("message", "新增失败！");
				response.sendRedirect(path+"/AddStandard.jsp");
				return;
			}
		}
	}

}
