package com.YANG.BDQN_shop.dao.ming;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YANG.BDQN_shop.entity.ming.LiuYan;

public interface ChaXunDao {
	public List<LiuYan> cx(@Param("id")int id);
}
