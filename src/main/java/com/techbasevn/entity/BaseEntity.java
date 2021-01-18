package com.techbasevn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=100)
	private String name;

	@Column(name = "created_by", length = 20, updatable = false)
	@CreatedBy
	private String createdBy;

	@Column(name = "created_date", updatable = false)
	@CreatedDate
	private Date createdDate;

	@Column(name = "modified_by", length = 20)
	@LastModifiedBy
	private String modifiedBy;

	@Column(name = "modified_date")
	@LastModifiedDate
	private Date modifiedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}
}