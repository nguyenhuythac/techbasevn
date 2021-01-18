package com.techbasevn.dto;

import java.util.Date;

public class AbstractDTO<T> {

	private Integer id;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;

	public AbstractDTO(int id) {
		super();
		this.id = id;
	}

	public AbstractDTO(int id, Date createdDate, String createdBy) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public AbstractDTO(int id,String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public AbstractDTO() {
		super();
	}

	public AbstractDTO(int id, Date modifiedDate) {
		this.id = id;
		this.modifiedDate = modifiedDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
