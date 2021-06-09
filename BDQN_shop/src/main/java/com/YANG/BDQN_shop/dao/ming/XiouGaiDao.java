package com.YANG.BDQN_shop.dao.ming;


import java.sql.Date;

import org.apache.ibatis.annotations.Param;


public interface XiouGaiDao {
	public int xiougai(@Param("reply")String reply,@Param("Date")Date time,@Param("id")int id);
}
