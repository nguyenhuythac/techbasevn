package com.techbasevn.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO extends AbstractDTO<EmployeeDTO> {

	private Integer age;
	private String gender;
	private String email;
	private String address;
	private String phone;
	private String position;
	private Long salary;
	private List<TeamDTO> teams;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Integer id, String name) {
		super(id, name);
	}

	public EmployeeDTO(Integer id, String name, String address, Integer age, String email, String gender, String phone,
			String position, Long salary) {
		super(id, name);
		this.address = address;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		this.position = position;
		this.salary = salary;
	}

}
