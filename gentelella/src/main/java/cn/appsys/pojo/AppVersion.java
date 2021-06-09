package cn.appsys.pojo;

import java.util.Date;

public class AppVersion {
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * appId（来源于：app_info表的主键id）
	 */
	private Integer appId;
	/**
	 * 版本号
	 */
	private String versionNo;
	/**
	 * 版本介绍
	 */
	private String versionInfo;
	/**
	 * 发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
	 */
	private Integer publishStatus;
	/**
	 * 下载链接
	 */
	private String downloadLink;
	/**
	 * 版本大小（单位：M）
	 */
	private double versionSize;
	/**
	 * 创建者（来源于dev_user开发者信息表的用户id）
	 */
	private Integer createdByl;
	/**
	 * 创建时间
	 */
	private Date creationDate;
	/**
	 * 更新者（来源于dev_user开发者信息表的用户id）
	 */
	private Integer modifyBy;
	/**
	 * 最新更新时间
	 */
	private Date modifyDate;
	/**
	 * apk文件的服务器存储路径
	 */
	private String apkLocPath;
	/**
	 * 上传的apk文件名称
	 */
	private String apkFileName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public String getVersionInfo() {
		return versionInfo;
	}
	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}
	public Integer getPublishStatus() {
		return publishStatus;
	}
	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}
	public String getDownloadLink() {
		return downloadLink;
	}
	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}
	public double getVersionSize() {
		return versionSize;
	}
	public void setVersionSize(double versionSize) {
		this.versionSize = versionSize;
	}
	public Integer getCreatedByl() {
		return createdByl;
	}
	public void setCreatedByl(Integer createdByl) {
		this.createdByl = createdByl;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getApkLocPath() {
		return apkLocPath;
	}
	public void setApkLocPath(String apkLocPath) {
		this.apkLocPath = apkLocPath;
	}
	public String getApkFileName() {
		return apkFileName;
	}
	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}
	
	
}
