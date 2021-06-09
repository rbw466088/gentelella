package com.gdglc.StuManagement.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Student {
    private Integer id;
    @NotEmpty(message="姓名不能为空！")
    private String name;
    @NotNull(message="年龄不能为空！")
    private Integer age;
    @NotEmpty(message="性别不能为空！")
    private String gender;
    @NotEmpty(message="电话号码不能为空！")
    private String telephone;
    @NotEmpty(message="邮箱不能为空！")
    private String email;
    @NotNull(message="请选择班级！")
    private Integer classid;
    
    private String classname;

    public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}