package com.techbasevn.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="team")
public class TeamEntity extends BaseEntity{
	@ManyToOne()
	@JoinColumn(name="depart_id")
	private DepartEntity depart;
	
	@ManyToMany()
	@JoinTable(name = "team_employee", 
    	joinColumns = @JoinColumn(name = "team_id"),  
    	inverseJoinColumns = @JoinColumn(name = "employee_id")) 
	private List<EmployeeEntity> employees;

	public DepartEntity getDepart() {
		return depart;
	}

	public void setDepart(DepartEntity depart) {
		this.depart = depart;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}
	
	
	
}
