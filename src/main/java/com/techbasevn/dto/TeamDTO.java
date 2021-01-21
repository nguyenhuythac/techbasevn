package com.techbasevn.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TeamDTO extends AbstractDTO<TeamDTO>{
	@JsonIgnore
	private DepartDTO depart=new DepartDTO();
	
	@JsonIgnore
	private List<EmployeeDTO> employees=new ArrayList<EmployeeDTO>();
	
}
