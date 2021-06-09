package com.YANG.BDQN_shop.service.ming;

import org.apache.ibatis.annotations.Param;

public interface IZhuCeService {
	public int ZhuCe(@Param("id")String id, @Param("name")String name, @Param("password")String password, @Param("sex")String sex,
			@Param("birthday")String birthday, @Param("identity")String identity, @Param("email")String email, @Param("mobile")String mobile,
			@Param("address")String address);
}
