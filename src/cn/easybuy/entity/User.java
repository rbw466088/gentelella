package cn.easybuy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 */
public class User implements Serializable {
	private static final long serialVersionUID = 401511397327644394L;
	private Integer id;// 用户ID
	private String loginName;// 登录名称
	private String userName;// 用户名
	private String password;// 用户密码
	private Integer sex;// 用户性别
	private String identityCode;// 身份证号码
	private String email;// 电子邮箱
	private String mobile;// 用户电话
	private Integer type;// 用户类别（前台，后台）

	/**
	 * 获取用户ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置用户ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取登录名称
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置登录名称
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 获取用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取用户密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置用户密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取用户性别
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * 设置用户性别
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * 获取身份证号码
	 */
	public String getIdentityCode() {
		return identityCode;
	}

	/**
	 * 设置身份证号码
	 */
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	/**
	 * 获取电子邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取用户电话
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置用户电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取用户类别（前台，后台）
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置用户类别（前台，后台）
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", userName=" + userName + ", password=" + password
				+ ", sex=" + sex + ", identityCode=" + identityCode + ", email=" + email + ", mobile=" + mobile
				+ ", type=" + type + "]";
	}
	
	

}
