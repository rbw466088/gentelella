package com.YANG.BDQN_shop.dao.ming;

import org.apache.ibatis.annotations.Param;

public interface ShanChuDao {
	public int shanchu(@Param("id")int id);
}
