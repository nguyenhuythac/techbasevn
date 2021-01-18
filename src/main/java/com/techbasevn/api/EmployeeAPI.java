package com.techbasevn.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techbasevn.dto.EmployeeDTO;
import com.techbasevn.service.IEmployeeService;

@RestController(value = "employeeAPI")
@RequestMapping("api/employee")
public class EmployeeAPI {
	@Autowired
	private IEmployeeService employeeService;
	
	//API show all of employee in The company
	@GetMapping()
	public ResponseEntity<List<EmployeeDTO>> employeeList() {
		// limit of employees API return is 1500
		Pageable limit = PageRequest.of(0, 1500);
		List<EmployeeDTO> employees = employeeService.findAll(limit);
		if (employees.isEmpty())
			return new ResponseEntity<List<EmployeeDTO>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<EmployeeDTO>>(employees, HttpStatus.OK);
	}
}
