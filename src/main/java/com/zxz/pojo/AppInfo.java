package com.zxz.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AppInfo entity. @author MyEclipse Persistence Tools
 */

public class AppInfo implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 818830750713899560L;
	private Long id;
	private String softwareName;
	private String apkname;
	private String supportRom;
	private String interfaceLanguage;
	private Double softwareSize;
	private Date updateDate;
	private Long devId;
	private String appInfo;
	private Long status;
	private Timestamp onSaleDate;
	private Timestamp offSaleDate;
	private Long flatformId;
	private Long categoryLevel3;
	private Long downloads;
	private Long createdBy;
	private Timestamp creationDate;
	private Long modifyBy;
	private Timestamp modifyDate;
	private Long categoryLevel1;
	private Long categoryLevel2;
	private String logoPicPath;
	private String logoLocPath;
	private Long versionId;
	
	private String statusName;//app状态名称
	private String flatformName;//app所属平台名称
	private String categoryLevel3Name;//所属三级分类名称
	private String devName;//开发者名称
	
	private String categoryLevel1Name;//所属一级分类名称
	private String categoryLevel2Name;//所属二级分类名称
	
	private String versionNo;//最新的版本号

	// Constructors

	/** default constructor */
	public AppInfo() {
	}

	/** full constructor */
	public AppInfo(String softwareName, String apkname, String supportRom, String interfaceLanguage,
			Double softwareSize, Date updateDate, Long devId, String appInfo, Long status, Timestamp onSaleDate,
			Timestamp offSaleDate, Long flatformId, Long categoryLevel3, Long downloads, Long createdBy,
			Timestamp creationDate, Long modifyBy, Timestamp modifyDate, Long categoryLevel1, Long categoryLevel2,
			String logoPicPath, String logoLocPath, Long versionId) {
		this.softwareName = softwareName;
		this.apkname = apkname;
		this.supportRom = supportRom;
		this.interfaceLanguage = interfaceLanguage;
		this.softwareSize = softwareSize;
		this.updateDate = updateDate;
		this.devId = devId;
		this.appInfo = appInfo;
		this.status = status;
		this.onSaleDate = onSaleDate;
		this.offSaleDate = offSaleDate;
		this.flatformId = flatformId;
		this.categoryLevel3 = categoryLevel3;
		this.downloads = downloads;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.categoryLevel1 = categoryLevel1;
		this.categoryLevel2 = categoryLevel2;
		this.logoPicPath = logoPicPath;
		this.logoLocPath = logoLocPath;
		this.versionId = versionId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSoftwareName() {
		return this.softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getApkname() {
		return this.apkname;
	}

	public void setApkname(String apkname) {
		this.apkname = apkname;
	}

	public String getSupportRom() {
		return this.supportRom;
	}

	public void setSupportRom(String supportRom) {
		this.supportRom = supportRom;
	}

	public String getInterfaceLanguage() {
		return this.interfaceLanguage;
	}

	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}

	public Double getSoftwareSize() {
		return this.softwareSize;
	}

	public void setSoftwareSize(Double softwareSize) {
		this.softwareSize = softwareSize;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getDevId() {
		return this.devId;
	}

	public void setDevId(Long devId) {
		this.devId = devId;
	}

	public String getAppInfo() {
		return this.appInfo;
	}

	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Timestamp getOnSaleDate() {
		return this.onSaleDate;
	}

	public void setOnSaleDate(Timestamp onSaleDate) {
		this.onSaleDate = onSaleDate;
	}

	public Timestamp getOffSaleDate() {
		return this.offSaleDate;
	}

	public void setOffSaleDate(Timestamp offSaleDate) {
		this.offSaleDate = offSaleDate;
	}

	public Long getFlatformId() {
		return this.flatformId;
	}

	public void setFlatformId(Long flatformId) {
		this.flatformId = flatformId;
	}

	public Long getCategoryLevel3() {
		return this.categoryLevel3;
	}

	public void setCategoryLevel3(Long categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}

	public Long getDownloads() {
		return this.downloads;
	}

	public void setDownloads(Long downloads) {
		this.downloads = downloads;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Long getModifyBy() {
		return this.modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Timestamp getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getCategoryLevel1() {
		return this.categoryLevel1;
	}

	public void setCategoryLevel1(Long categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}

	public Long getCategoryLevel2() {
		return this.categoryLevel2;
	}

	public void setCategoryLevel2(Long categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}

	public String getLogoPicPath() {
		return this.logoPicPath;
	}

	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}

	public String getLogoLocPath() {
		return this.logoLocPath;
	}

	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}

	public Long getVersionId() {
		return this.versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getFlatformName() {
		return flatformName;
	}

	public void setFlatformName(String flatformName) {
		this.flatformName = flatformName;
	}

	public String getCategoryLevel3Name() {
		return categoryLevel3Name;
	}

	public void setCategoryLevel3Name(String categoryLevel3Name) {
		this.categoryLevel3Name = categoryLevel3Name;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getCategoryLevel1Name() {
		return categoryLevel1Name;
	}

	public void setCategoryLevel1Name(String categoryLevel1Name) {
		this.categoryLevel1Name = categoryLevel1Name;
	}

	public String getCategoryLevel2Name() {
		return categoryLevel2Name;
	}

	public void setCategoryLevel2Name(String categoryLevel2Name) {
		this.categoryLevel2Name = categoryLevel2Name;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

}