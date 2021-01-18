package com.techbasevn.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TeamDTO extends AbstractDTO<TeamDTO>{
	@JsonIgnore
	private DepartDTO depart=new DepartDTO();
	
	@JsonIgnore
	private List<EmployeeDTO> employees=new ArrayList<EmployeeDTO>();
	
	public DepartDTO getDepart() {
		return depart;
	}
	public void setDepart(DepartDTO depart) {
		this.depart = depart;
	}
	public List<EmployeeDTO> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeDTO> employees) {
		this.employees = employees;
	}
	
}
