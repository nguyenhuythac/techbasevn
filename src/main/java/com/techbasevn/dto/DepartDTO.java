package com.techbasevn.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartDTO extends AbstractDTO<DepartDTO> {

	private EmployeeDTO manager = new EmployeeDTO();
	private List<TeamDTO> teams = new ArrayList<TeamDTO>();

}
