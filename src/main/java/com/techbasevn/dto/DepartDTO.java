package com.techbasevn.dto;

import java.util.ArrayList;
import java.util.List;

public class DepartDTO extends AbstractDTO<DepartDTO>{
	
	private EmployeeDTO manager=new EmployeeDTO();
	private List<TeamDTO> teams=new ArrayList<TeamDTO>();
	public EmployeeDTO getManager() {
		return manager;
	}
	public void setManager(EmployeeDTO manager) {
		this.manager = manager;
	}
	public List<TeamDTO> getTeams() {
		return teams;
	}
	public void setTeams(List<TeamDTO> teams) {
		this.teams = teams;
	}
	
	
}
