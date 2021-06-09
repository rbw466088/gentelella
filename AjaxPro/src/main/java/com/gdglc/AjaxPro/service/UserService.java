package com.gdglc.AjaxPro.service;

import org.apache.ibatis.annotations.Param;

import com.gdglc.AjaxPro.entity.User;

public interface UserService {
    /**
     * 按用户名查询（用来判断用户名是否有重复）
     * @param name
     * @return
     */
    int selectByName(@Param("userName")String name);
    
    /**
     * 用户注册
     * @param record
     * @return
     */
    int insert(User record);
}
