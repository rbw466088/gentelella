package com.YANG.BDQN_shop.domain.common;

import java.io.Serializable;
import java.util.List;

public class PageInfo<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7875559590039640604L;
	
	int dangQianYe = 1;	//当前页
	int zongYe;			//总页数
	int showCounts = 8;	//每页显示的数量
	int counts;			//所有数量
	List<T> list;		//要显示的结果集
	
	public int getDangQianYe() {
		if(dangQianYe<=0){
			dangQianYe = 1;
			
		}else if(dangQianYe>zongYe){
			dangQianYe = zongYe;
		}
		return dangQianYe;
	}
	public void setDangQianYe(int dangQianYe) {
		this.dangQianYe = dangQianYe;
	}
	public int getZongYe() {
		return zongYe;
	}
	public void setZongYe(int zongYe) {
		this.zongYe = zongYe;
	}
	public int getShowCounts() {
		return showCounts;
	}
	public void setShowCounts(int showCounts) {
		this.showCounts = showCounts;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
		this.zongYe = counts/showCounts;
		if(counts%showCounts!=0){
			this.zongYe = this.zongYe+1;
		}
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
