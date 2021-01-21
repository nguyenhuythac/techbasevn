package com.techbasevn.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="depart")
@Getter
@Setter
public class DepartEntity extends BaseEntity{
	
	@OneToOne()
	@JoinColumn(name="employee_id")
	private EmployeeEntity manager;
	
	@OneToMany(mappedBy = "depart")
	private List<TeamEntity> teams;
	public EmployeeEntity getManager() {
		return manager;
	}

	public DepartEntity() {}
	
	public DepartEntity(Integer id,String name,Integer managerId,String managerName) {
		super(id,name);
		this.manager=new EmployeeEntity(managerId,managerName);
	}
	
	public DepartEntity(Integer id, String name) {
		super(id,name);
	}
	
}
