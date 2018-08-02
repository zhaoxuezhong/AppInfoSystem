package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AppCategory entity. @author MyEclipse Persistence Tools
 */

public class AppCategory implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 6010936670833702040L;
	private Long id;
	private String categoryCode;
	private String categoryName;
	private Long parentId;
	private Long createdBy;
	private Timestamp creationTime;
	private Long modifyBy;
	private Timestamp modifyDate;

	// Constructors

	/** default constructor */
	public AppCategory() {
	}

	/** full constructor */
	public AppCategory(String categoryCode, String categoryName, Long parentId, Long createdBy, Timestamp creationTime,
			Long modifyBy, Timestamp modifyDate) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.parentId = parentId;
		this.createdBy = createdBy;
		this.creationTime = creationTime;
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

	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
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