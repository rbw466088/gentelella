package com.gdglc.AjaxPro.service.impl;

import com.gdglc.AjaxPro.dao.UserMapper;
import com.gdglc.AjaxPro.entity.User;
import com.gdglc.AjaxPro.service.UserService;

public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public int selectByName(String name) {
		int num = 0;
		try {
			num = userMapper.selectByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int insert(User record) {
		int num = 0;
		try {
			num = userMapper.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

}
