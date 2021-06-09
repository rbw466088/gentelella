package cn.easybuy.param;

import cn.easybuy.entity.News;
/**
 * 分页对象类
 */
public class NewsParams extends News{
	private static final long serialVersionUID = -7237477226719581299L;

	//limit #{startIndex},#{pageSize}
	//<!-- LIMIT 4,3	表示从第4条之后开始查询，返回3条记录，忽略最前4条信息 -->
	
	private Integer startIndex;//忽略的条数
	
	private Integer pageSize;//显示的条数

	private String sort;//order by 的条件
	
	private boolean isPage=false;//是否分页
	
	
	/**
	 * 忽略的条数
	 */
	public Integer getStartIndex() {
		return startIndex;
	}

	/**
	 * 忽略的条数
	 */
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * 显示的条数
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 显示的条数
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * order by 的条件
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * order by 的条件
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * 是否分页
	 */
	public boolean isPage() {
		return isPage;
	}

	/**
	 * 是否分页
	 */
	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}

	/**
	 * 设置忽略的条数和显示的条数
	 */
	public void openPage(Integer startIndex, Integer pageSize) {
		this.isPage = true;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}
}
