package com.gdglc.stuSystem.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.gdglc.stuSystem.dao.StandardMapper;
import com.gdglc.stuSystem.entity.Standard;
import com.gdglc.stuSystem.service.IStandard;

public class StandardImpl implements IStandard {

	private StandardMapper standardMapper;
	
	public StandardMapper getStandardMapper() {
		return standardMapper;
	}

	public void setStandardMapper(StandardMapper standardMapper) {
		this.standardMapper = standardMapper;
	}
	
	@Override
	public List<Standard> selectAll(String zhname){
		List<Standard> StandardList = new ArrayList<Standard>();
		try {
			if(null!=zhname&&!"".equals(zhname)) {
				StandardList = standardMapper.selectAll(zhname);
			}else {
				StandardList = standardMapper.selectAll(null);
			}
			return StandardList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StandardList;
	}
	
	@Override
	public int deleteByID(List<String> id) {
		int num = 0;
		try {
			num = standardMapper.deleteByID(id);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	@Override
	public int countByStdNum(String stdNum) {
		int num = 0;
		try {
			if(null!=stdNum&&!"".equals(stdNum)) {
				num = standardMapper.countByStdNum(stdNum);
				return num;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int insert(Standard record) {
		int num = 0;
		try {
			if(null!=record) {
				num = standardMapper.insert(record);
				return num;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Standard selectByPrimaryKey(Integer id) {
		Standard standard = new Standard();
		try {
			if(null!=id) {
				standard = 	standardMapper.selectByPrimaryKey(id);
				return standard;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return standard;
	}

	@Override
	public int updateByPrimaryKey(Standard record) {
		int num = 0;
		try {
			if(null!=record) {
				num = standardMapper.updateByPrimaryKey(record);
				return num;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

}
