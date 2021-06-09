package com.YANG.BDQN_shop.service.ming;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YANG.BDQN_shop.entity.ming.HouTaiDingDan;

public interface IHouTaiDingDanService {
	public List<HouTaiDingDan> dingdan(HouTaiDingDan din);
	
	public List<HouTaiDingDan> fiandDingdan(@Param("name")String name);
	
	public List<HouTaiDingDan> userdingdan(HouTaiDingDan din);
}
