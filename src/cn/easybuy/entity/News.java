package cn.easybuy.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 新闻类
 */
public class News implements Serializable{
	private Integer id;//ID
	private String title;//标题
	private String content;//内容
	private Date createTime;//创建时间

	

	/**
	 * 获取新闻ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置新闻ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取新闻标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置新闻标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取新闻内容 
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置新闻内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取新闻创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置新闻创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + new SimpleDateFormat("yyyy-MM-dd").format(createTime) + "]";
	}
	
	
	
}
