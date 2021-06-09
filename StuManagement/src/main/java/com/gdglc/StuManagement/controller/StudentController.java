package com.gdglc.StuManagement.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdglc.StuManagement.entity.Classes;
import com.gdglc.StuManagement.entity.Student;
import com.gdglc.StuManagement.service.IClasses;
import com.gdglc.StuManagement.service.IStudent;

@Controller
@RequestMapping("/studentList")
public class StudentController {
	@Resource(name="stu")
	private IStudent student;
	
	@Resource(name="classes")
	private IClasses classes;

	public IClasses getClasses() {
		return classes;
	}

	public void setClasses(IClasses classes) {
		this.classes = classes;
	}

	public IStudent getStudent() {
		return student;
	}

	public void setStudent(IStudent student) {
		this.student = student;
	}
	
	/**
	 * 显示学员信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/stuInfo")
	public String showStandard(Model model) {
		List<Student> stuList = student.ShowStu();
		model.addAttribute("stuList", stuList);	//写入显示的数据集合
		return "StuInfo";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		List<Classes> showClass = classes.ShowClass();
		model.addAttribute("showClass", showClass);	//写入显示的数据集合
		return "AddStudent";
	}
	
	@RequestMapping("AddStu")
	public String AddStu(@Valid @ModelAttribute("stu")Student stu,BindingResult result,
			HttpSession session,Model model) {
		
		//后台验证表单
		if(result.hasErrors()) {
			List<FieldError> fieldError = result.getFieldErrors();
			if(null!=fieldError) {
				for (FieldError error : fieldError) {
					System.out.println("名称："+error.getField()+"\n错误信息："+error.getDefaultMessage());
					model.addAttribute("error"+error.getField(), error.getDefaultMessage());
				}
			}
			return "forward:add";
		}
		
		int num = 0;
		num = student.insert(stu);
		if(num!=0) {
			session.setAttribute("message", "添加成功！");
			return "redirect:/studentList/stuInfo";
		}else {
			session.setAttribute("message", "添加失败！");
			return "forward:add";
		}
		
	}
	
	
	
	
	
}
