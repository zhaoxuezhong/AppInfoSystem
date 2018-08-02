package com.zxz.pojo;

import java.sql.Timestamp;

/**
 * AdPromotion entity. @author MyEclipse Persistence Tools
 */

public class AdPromotion implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 8649856384288219393L;
	private Long id;
	private Long appId;
	private String adPicPath;
	private Long adPv;
	private Integer carouselPosition;
	private Timestamp startTime;
	private Timestamp endTime;
	private Long createdBy;
	private Timestamp creationDate;
	private Long modifyBy;
	private Timestamp modifyDate;

	// Constructors

	/** default constructor */
	public AdPromotion() {
	}

	/** full constructor */
	public AdPromotion(Long appId, String adPicPath, Long adPv, Integer carouselPosition, Timestamp startTime,
			Timestamp endTime, Long createdBy, Timestamp creationDate, Long modifyBy, Timestamp modifyDate) {
		this.appId = appId;
		this.adPicPath = adPicPath;
		this.adPv = adPv;
		this.carouselPosition = carouselPosition;
		this.startTime = startTime;
		this.endTime = endTime;
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

	public Long getAppId() {
		return this.appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getAdPicPath() {
		return this.adPicPath;
	}

	public void setAdPicPath(String adPicPath) {
		this.adPicPath = adPicPath;
	}

	public Long getAdPv() {
		return this.adPv;
	}

	public void setAdPv(Long adPv) {
		this.adPv = adPv;
	}

	public Integer getCarouselPosition() {
		return this.carouselPosition;
	}

	public void setCarouselPosition(Integer carouselPosition) {
		this.carouselPosition = carouselPosition;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
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