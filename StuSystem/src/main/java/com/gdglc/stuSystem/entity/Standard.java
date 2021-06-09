package com.gdglc.stuSystem.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Standard {
    private Integer id;
    
    @NotEmpty(message="标准号不能为空！")
    private String stdNum;
    
    @NotEmpty(message="中文名称不能为空！")
    private String zhname;
    
    @NotEmpty(message="版本不能为空！")
    private String version;
    
    @NotEmpty(message="关键词/字不能为空！")
    private String keys;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date releaseDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date implDate;

    private String packagePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStdNum() {
        return stdNum;
    }

    public void setStdNum(String stdNum) {
        this.stdNum = stdNum == null ? null : stdNum.trim();
    }

    public String getZhname() {
        return zhname;
    }

    public void setZhname(String zhname) {
        this.zhname = zhname == null ? null : zhname.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys == null ? null : keys.trim();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getImplDate() {
        return implDate;
    }

    public void setImplDate(Date implDate) {
        this.implDate = implDate;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath == null ? null : packagePath.trim();
    }

    
	public Standard() {
		super();
	}

	public Standard(String stdNum, String zhname, String version, String keys, Date releaseDate, Date implDate,
			String packagePath) {
		super();
		this.stdNum = stdNum;
		this.zhname = zhname;
		this.version = version;
		this.keys = keys;
		this.releaseDate = releaseDate;
		this.implDate = implDate;
		this.packagePath = packagePath;
	}
    
}