package com.YANG.BDQN_shop.service.ming;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

public interface IXiouGaiService {
	public int xiougai(@Param("reply")String reply,@Param("Date")Date time,@Param("id")int id);
}
