package com.YANG.BDQN_shop.service.ming;

import org.apache.ibatis.annotations.Param;

public interface IShanChuService {
	public int shanchu(@Param("id")int id);
}
