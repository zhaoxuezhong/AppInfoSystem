package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * DevUser entity. @author MyEclipse Persistence Tools
 */

public class DevUser implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -6357074385318522685L;
	private Long id;
	private String devCode;
	private String devName;
	private String devPassword;
	private String devEmail;
	private String devInfo;
	private Long createdBy;
	private Timestamp creationDate;
	private Long modifyBy;
	private Timestamp modifyDate;

	// Constructors

	/** default constructor */
	public DevUser() {
	}

	/** full constructor */
	public DevUser(String devCode, String devName, String devPassword, String devEmail, String devInfo, Long createdBy,
			Timestamp creationDate, Long modifyBy, Timestamp modifyDate) {
		this.devCode = devCode;
		this.devName = devName;
		this.devPassword = devPassword;
		this.devEmail = devEmail;
		this.devInfo = devInfo;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDevCode() {
		return this.devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	public String getDevName() {
		return this.devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getDevPassword() {
		return this.devPassword;
	}

	public void setDevPassword(String devPassword) {
		this.devPassword = devPassword;
	}

	public String getDevEmail() {
		return this.devEmail;
	}

	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}

	public String getDevInfo() {
		return this.devInfo;
	}

	public void setDevInfo(String devInfo) {
		this.devInfo = devInfo;
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

}