package cn.appsys.pojo;

import java.util.Date;

public class AppInfo {
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 软件名称
	 */
	private String softwareName;
	/**
	 * APK名称（唯一）
	 */
	private String APKName;
	/**
	 * 支持ROM
	 */
	private String supportROM;
	/**
	 * 界面语言
	 */
	private String interfaceLanguage;
	/**
	 * 软件大小（单位：M）
	 */
	private double softwareSize;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * 开发者id（来源于：dev_user表的开发者id）
	 */
	private Integer devId;
	/**
	 * 应用简介
	 */
	private String appInfo;
	/**
	 * 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
	 */
	private Integer status;
	/**
	 * 上架时间
	 */
	private Date onSaleDate;
	/**
	 * 下架时间
	 */
	private Date offSaleDate;
	/**
	 * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
	 */
	private Integer flatformId;
	/**
	 * 所属三级分类（来源于：data_dictionary）
	 */
	private Integer categoryLevel3;
	/**
	 * 下载量（单位：次）
	 */
	private Integer downloads;
	/**
	 * 创建者（来源于dev_user开发者信息表的用户id）
	 */
	private Integer createdBy;
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
	 * 所属一级分类（来源于：data_dictionary）
	 */
	private Integer categoryLevel1;
	/**
	 * 所属二级分类（来源于：data_dictionary）
	 */
	private Integer categoryLevel2;
	/**
	 * LOGO图片url路径
	 */
	private String logoPicPath;
	/**
	 * LOGO图片的服务器存储路径
	 */
	private String logoLocPath;
	/**
	 * 最新的版本id
	 */
	private Integer versionId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public String getAPKName() {
		return APKName;
	}
	public void setAPKName(String aPKName) {
		APKName = aPKName;
	}
	public String getSupportROM() {
		return supportROM;
	}
	public void setSupportROM(String supportROM) {
		this.supportROM = supportROM;
	}
	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}
	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}
	public double getSoftwareSize() {
		return softwareSize;
	}
	public void setSoftwareSize(double softwareSize) {
		this.softwareSize = softwareSize;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getDevId() {
		return devId;
	}
	public void setDevId(Integer devId) {
		this.devId = devId;
	}
	public String getAppInfo() {
		return appInfo;
	}
	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getOnSaleDate() {
		return onSaleDate;
	}
	public void setOnSaleDate(Date onSaleDate) {
		this.onSaleDate = onSaleDate;
	}
	public Date getOffSaleDate() {
		return offSaleDate;
	}
	public void setOffSaleDate(Date offSaleDate) {
		this.offSaleDate = offSaleDate;
	}
	public Integer getFlatformId() {
		return flatformId;
	}
	public void setFlatformId(Integer flatformId) {
		this.flatformId = flatformId;
	}
	public Integer getCategoryLevel3() {
		return categoryLevel3;
	}
	public void setCategoryLevel3(Integer categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}
	public Integer getDownloads() {
		return downloads;
	}
	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
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
	public Integer getCategoryLevel1() {
		return categoryLevel1;
	}
	public void setCategoryLevel1(Integer categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}
	public Integer getCategoryLevel2() {
		return categoryLevel2;
	}
	public void setCategoryLevel2(Integer categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}
	public String getLogoPicPath() {
		return logoPicPath;
	}
	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}
	public String getLogoLocPath() {
		return logoLocPath;
	}
	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	
}
