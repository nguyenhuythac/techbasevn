package com.techbasevn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name="team")
@Getter
@Setter
public class TeamEntity extends BaseEntity{
	@ManyToOne()
	@JoinColumn(name="depart_id")
	private DepartEntity depart;
	
	@ManyToMany(targetEntity = EmployeeEntity.class, cascade = {CascadeType.ALL})
	@JoinTable(name = "team_employee", 
    	joinColumns = @JoinColumn(name = "team_id"),  
    	inverseJoinColumns = @JoinColumn(name = "employee_id")) 
	private List<EmployeeEntity> employees;
	
	public TeamEntity() {}
	public TeamEntity(Integer id,String name){
		super(id,name);
	}
	public TeamEntity(Integer id,String name,Integer departId,String departName){
		super(id,name);
		this.depart=new DepartEntity(departId,departName);
	}
	
	
	
}
