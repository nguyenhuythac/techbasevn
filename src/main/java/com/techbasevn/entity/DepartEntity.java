package com.techbasevn.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="depart")
public class DepartEntity extends BaseEntity{
	
	@OneToOne()
	@JoinColumn(name="employee_id")
	private EmployeeEntity manager;
	
	@OneToMany(mappedBy = "depart")
	private List<TeamEntity> teams;

	public EmployeeEntity getManager() {
		return manager;
	}

	public void setManager(EmployeeEntity manager) {
		this.manager = manager;
	}

	public List<TeamEntity> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamEntity> teams) {
		this.teams = teams;
	}
	
}
