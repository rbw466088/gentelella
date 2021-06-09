package com.YANG.BDQN_shop.service.ming;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YANG.BDQN_shop.entity.ming.LiuYan;

public interface IChaXunService {
	public List<LiuYan> cx(@Param("id")int id);
}
