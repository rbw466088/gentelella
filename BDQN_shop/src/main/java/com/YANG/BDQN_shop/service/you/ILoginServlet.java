package com.YANG.BDQN_shop.service.you;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YANG.BDQN_shop.entity.you.LoginEntity;

public interface ILoginServlet {
	/**
	 * 检查登录
	 * @param info
	 * @return
	 */
	public LoginEntity findAll(LoginEntity info);
	
	/**
	 * 判断是管理员还是普通用户
	 * @param id
	 * @param pwd
	 * @return
	 */
	public int status(@Param("id")String id,@Param("pwd")String pwd);
	
	/**
	 * 获取id值
	 * @param id
	 * @return
	 */
	public LoginEntity loginById(@Param("id")String id);//获取id值ֵ
	
	/**
	 * 修改数据
	 * @param login
	 * @return
	 */
	public int update(LoginEntity login);
	
	/**
	 * 查询数据
	 * @param id
	 * @return
	 */
	public List<LoginEntity> findAlls(@Param("id")String id);
}
