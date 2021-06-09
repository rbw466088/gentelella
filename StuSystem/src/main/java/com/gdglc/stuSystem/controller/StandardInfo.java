package com.gdglc.stuSystem.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdglc.stuSystem.controller.commonException.ErrorMessage;
import com.gdglc.stuSystem.entity.Standard;
import com.gdglc.stuSystem.service.IStandard;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/standardInfo")
public class StandardInfo extends ErrorMessage{
	//获取service接口对象
	@Resource(name="standard")
	private IStandard standard;
	
	public IStandard getStandard() {
		return standard;
	}

	public void setStandard(IStandard standard) {
		this.standard = standard;
	}
	
	/**
	 * 把前台页面的String日期类型装换为Date类型
	 * @param binder
	 */
//	@InitBinder  
//	public void initBinder(WebDataBinder binder) {  
//	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
//	    dateFormat.setLenient(false);  
//	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); //true:允许输入空值，false:不能为空值  
//	}

	/**
	 * 主页面显示
	 * @param model
	 * @param pageNum
	 * @param zhname
	 * @return
	 */
	@RequestMapping("/ShowStandard")
	public String showStandard(Model model,String pageNum,String zhname) {
	
		//分页显示
		int page = 1;
		if(pageNum==null || pageNum.equals("")){
			page = 1;
		}else{
			page = Integer.parseInt(pageNum);
		}
		//设置分页，必须在获取数据之前注入
		PageHelper.startPage(page,2);
		
		//查询信息
		List<Standard> standardList = standard.selectAll(zhname);
		
		//获取分页
		PageInfo<Standard> info = new PageInfo<Standard>(standardList);
		
		//写入Model，用于表示层操作
		model.addAttribute("zhname", zhname);	//写入查询条件，用于作表示层的条件保留
		model.addAttribute("info", info);		//写入分页
		model.addAttribute("standardList", standardList);	//写入显示的数据集合
		//返回视图页面
		return "ShowStandard";
	}
	
	/**
	 * 页面跳转（主页面跳转到添加页面）
	 * @return
	 */
	@RequestMapping("/add")
	public String addStandard() {
		return "AddStandard";
	}
	
	/**
	 * 添加数据
	 * @param stan
	 * @param session
	 * @param attributes
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/AddStandard",method=RequestMethod.POST)
	public String addStandard(@Valid @ModelAttribute("stan")Standard stan,BindingResult result,Model model,
			HttpSession session,RedirectAttributes attributes,MultipartFile file,MultipartFile file2) {
		
		//后台验证表单
		if(result.hasErrors()) {
			List<FieldError> fieldError = result.getFieldErrors();
			if(null!=fieldError) {
				for (FieldError error : fieldError) {
					System.out.println("名称："+error.getField()+"\n错误信息："+error.getDefaultMessage());
					model.addAttribute(error.getField(), error.getDefaultMessage());
				}
			}
			if(file.getSize()<=0) {
				model.addAttribute("file", "附件不能为空！");
			}
			return "forward:add";
		}
		
		//发布文件上传的全路径
		String idPicPath = null;
		//判断文件是否为空
		if(!file.isEmpty()) {
			// 构造临时路径来存储上传的文件
	        // 这个路径相对当前应用的目录  /statics/images/
			String path = session.getServletContext().getRealPath("/statics") + File.separator + "images";
			//原文件名
			String oldFileName = file.getOriginalFilename();
			//原文件名后缀
			String prefix = FilenameUtils.getExtension(oldFileName);
			//设置限制文件上传大小的字节数
			int filesize = 512000;
			if(file2.getSize()>filesize) {
				attributes.addFlashAttribute("message", "上传大小不得超过500KB");
				return "redirect:/standardInfo/add";
			}else
			if(file.getSize()>filesize){	//上传大小不得超过500KB
				attributes.addFlashAttribute("message", "上传大小不得超过500KB");
				return "redirect:/standardInfo/add";
			}else if(prefix.equalsIgnoreCase("jpg")||prefix.equalsIgnoreCase("png")||	
					prefix.equalsIgnoreCase("jpeg")||prefix.equalsIgnoreCase("pneg")){	//上传图片格式
				//当前系统时间+随机数，产生新的文件名
				String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_Personal.jpg";
				File pathName = new File(path,fileName);
				if(!pathName.exists()) {
					pathName.mkdirs();
				}
				//保存文件
				try {
					file.transferTo(pathName);
				} catch (Exception e) {
					e.printStackTrace();
					attributes.addFlashAttribute("message", "上传失败！");
					return "redirect:/standardInfo/add"; 
				}
				//文件上传发布的绝对路径
				idPicPath = path+File.separator+fileName;
				//把文件的新名称插入数据库
				stan.setPackagePath(fileName);
			}else {
				attributes.addFlashAttribute("message", "上传图片格式不正确！");
				return "redirect:/standardInfo/add";
			}
		}
		//按标准号获取数量，用作验证是否有重复标准号
		int byStdNum = standard.countByStdNum(stan.getStdNum());
		if(byStdNum!=0) {
			//有重复数据
			attributes.addFlashAttribute("message", "标准号重复！");
			return "redirect:/standardInfo/add";
		}else {
			//没有重复则新增数据
			int num = standard.insert(stan);	//调用添加方法
			if(num!=0) {
				attributes.addFlashAttribute("message", "新增成功！");
				return "redirect:/standardInfo/ShowStandard";
			}else {
				attributes.addFlashAttribute("message", "新增失败！");
				return "redirect:/standardInfo/add";
			}
		}
	}
	
	/**
	 * 按id查询信息
	 * @param model
	 * @param 页面获取的id 
	 * @return 转发到修改的页面
	 */
	@RequestMapping("/StandardById")
	public String StandardById(Model model,String id) {
		//获取前台id
		Integer ids = Integer.parseInt(id);
		//根据ID调用方法获取数据
		Standard stan = standard.selectByPrimaryKey(ids);
		model.addAttribute("stan",stan);
		return "UpdateStandard";
	}
	
	/**
	 * 查询数据
	 * @param stan
	 * @param session
	 * @param attributes
	 * @param file
	 * @return
	 */
	@RequestMapping("/UpdateStandard")
	public String UpdateStandard(@Valid @ModelAttribute("stan")Standard stan,BindingResult result,Model model,
			HttpSession session,RedirectAttributes attributes,MultipartFile file) {
		
		//后台验证表单
		if(result.hasErrors()) {
			List<FieldError> fieldError = result.getFieldErrors();
			if(null!=fieldError) {
				for (FieldError error : fieldError) {
					System.out.println("名称："+error.getField()+"\n错误信息："+error.getDefaultMessage());
					model.addAttribute(error.getField(), error.getDefaultMessage());
				}
			}
			return "forward:StandardById";
		}
		
		String idPicPath = null;
		//判断文件是否为空（不为空则获取新的文件路径）
		if(!file.isEmpty()) {
			// 构造临时路径来存储上传的文件
	        // 这个路径相对当前应用的目录
			String path = session.getServletContext().getRealPath("statics") + File.separator + "images";
			//原文件名
			String oldFileName = file.getOriginalFilename();
			//原文件名后缀
			String prefix = FilenameUtils.getExtension(oldFileName);
			//设置限制文件上传大小的字节数
			int filesize = 500000;
			
			if(file.getSize()>filesize){	//上传大小不得超过500KB
				attributes.addFlashAttribute("message", "上传大小不得超过500KB");
				return "redirect:/standardInfo/StandardById?id="+stan.getId();
			}else if(prefix.equalsIgnoreCase("jpg")||prefix.equalsIgnoreCase("png")||	
					prefix.equalsIgnoreCase("jpeg")||prefix.equalsIgnoreCase("pneg")){	//上传图片格式
				//当前系统时间+随机数，产生新的文件名
				String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_Personal.jpg";
				File pathName = new File(path,fileName);
				if(!pathName.exists()) {
					pathName.mkdirs();
				}
				//保存文件
				try {
					file.transferTo(pathName);
				} catch (Exception e) {
					e.printStackTrace();
					attributes.addFlashAttribute("message", "上传失败！");
					return "redirect:/standardInfo/StandardById?id="+stan.getId(); 
				}
				//文件上传发布的绝对路径
				idPicPath = path+File.separator+fileName;
				//把文件的新名称插入数据库
				stan.setPackagePath(fileName);
			}else {
				attributes.addFlashAttribute("message", "上传图片格式不正确！");
				return "redirect:/standardInfo/StandardById?id="+stan.getId();
			}
		}
  		//调用修改方法
  		int num = standard.updateByPrimaryKey(stan);
		if(num!=0) {
			attributes.addFlashAttribute("message", "修改成功！");
			return "redirect:/standardInfo/ShowStandard";
		}else {
			attributes.addFlashAttribute("message", "修改失败！");
			return "redirect:/standardInfo/StandardById?id="+stan.getId();
		}
	}
	
	/**
	 * 删除数据
	 * @param delParam
	 * @param attributes
	 * @return
	 */
	@RequestMapping("/DeleteStandard")
	public String DeleteStandard(@Param("delParam")String delParam,RedirectAttributes attributes) {
		//把前台传过来String类型的id拆解分割
		String[] split = delParam.split(",");
		List<String> idList = new ArrayList<String>();
		if(delParam!=null) {
			for(int i=0;i<split.length;i++)
			 {
				//分割后写进List集合作为参数（用作删除条件）
				idList.add(split[i]);
			 }
	        //调用删除方法
	        int deleteByID = standard.deleteByID(idList);
	        if(deleteByID!=0) {
	        	attributes.addFlashAttribute("message", "删除成功！");
	        }else {
	        	attributes.addFlashAttribute("message", "删除失败！");
	        }
		}
		return "redirect:/standardInfo/ShowStandard";
	}
	
	/**
	 * 文件下载
	 * @param id
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("down/{id}")
	public ResponseEntity<byte[]> down(@PathVariable("id")Integer id,HttpSession session) throws Exception{
		System.out.println("根据id获取对应的附件路径,id="+id);
		//根据ID调用方法获取数据，用来取文件名称
		Standard stan = standard.selectByPrimaryKey(id);
		//发布的目录路径
		String path = session.getServletContext().getRealPath("statics") + File.separator + "images";
		//发布的目录路径+文件名称
		path = path+File.separator+stan.getPackagePath();
		File file = new File(path);
		System.out.println("文件流中的文件名称"+file.getName());
	    byte[] body = null;
	    try(InputStream is = new FileInputStream(file)){
	    	 	body = new byte[is.available()];
	    	 	is.read(body);
	    }
	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=" + URLEncoder.encode(file.getName(),"UTF-8"));
	    HttpStatus statusCode = HttpStatus.OK;
	    ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
	    return entity;
	}
}
