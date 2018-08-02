package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * BackendUser entity. @author MyEclipse Persistence Tools
 */

public class BackendUser implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 3501968908942090148L;
	private Long id;
	private String userCode;
	private String userName;
	private Long userType;
	private String userTypeName;
	private Long createdBy;
	private Timestamp creationDate;
	private Long modifyBy;
	private Timestamp modifyDate;
	private String userPassword;

	// Constructors

	/** default constructor */
	public BackendUser() {
	}

	/** full constructor */
	public BackendUser(String userCode, String userName, Long userType, Long createdBy, Timestamp creationDate,
			Long modifyBy, Timestamp modifyDate, String userPassword) {
		this.userCode = userCode;
		this.userName = userName;
		this.userType = userType;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.userPassword = userPassword;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserType() {
		return this.userType;
	}

	public void setUserType(Long userType) {
		this.userType = userType;
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

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	@Override
	public String toString() {
		return "BackendUser [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", userType=" + userType
				+ ", userTypeName=" + userTypeName + ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + ", userPassword=" + userPassword + "]";
	}

}