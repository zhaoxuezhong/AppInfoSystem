package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AppVersion entity. @author MyEclipse Persistence Tools
 */

public class AppVersion implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 2438362525866725330L;
	private Long id;
	private Long appId;
	private String appName;
	private String versionNo;
	private String versionInfo;
	private Long publishStatus;
	private String publishStatusName;
	private String downloadLink;
	private Double versionSize;
	private Long createdBy;
	private Timestamp creationDate;
	private Long modifyBy;
	private Timestamp modifyDate;
	private String apkLocPath;
	private String apkFileName;

	// Constructors

	/** default constructor */
	public AppVersion() {
	}

	/** full constructor */
	public AppVersion(Long appId, String versionNo, String versionInfo, Long publishStatus, String downloadLink,
			Double versionSize, Long createdBy, Timestamp creationDate, Long modifyBy, Timestamp modifyDate,
			String apkLocPath, String apkFileName) {
		this.appId = appId;
		this.versionNo = versionNo;
		this.versionInfo = versionInfo;
		this.publishStatus = publishStatus;
		this.downloadLink = downloadLink;
		this.versionSize = versionSize;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.apkLocPath = apkLocPath;
		this.apkFileName = apkFileName;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAppId() {
		return this.appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getVersionNo() {
		return this.versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getVersionInfo() {
		return this.versionInfo;
	}

	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}

	public Long getPublishStatus() {
		return this.publishStatus;
	}

	public void setPublishStatus(Long publishStatus) {
		this.publishStatus = publishStatus;
	}

	public String getDownloadLink() {
		return this.downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public Double getVersionSize() {
		return this.versionSize;
	}

	public void setVersionSize(Double versionSize) {
		this.versionSize = versionSize;
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

	public String getApkLocPath() {
		return this.apkLocPath;
	}

	public void setApkLocPath(String apkLocPath) {
		this.apkLocPath = apkLocPath;
	}

	public String getApkFileName() {
		return this.apkFileName;
	}

	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getPublishStatusName() {
		return publishStatusName;
	}

	public void setPublishStatusName(String publishStatusName) {
		this.publishStatusName = publishStatusName;
	}

}