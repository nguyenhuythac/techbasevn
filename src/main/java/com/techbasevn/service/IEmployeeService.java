package com.techbasevn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.techbasevn.dto.EmployeeDTO;

public interface IEmployeeService {

	void deleteById(Integer id);

	long count();

	EmployeeDTO getOne(Integer id);

	boolean existsById(Integer id);

	Optional<EmployeeDTO> findById(Integer id);

	List<EmployeeDTO> findAll(Pageable pageable);

	EmployeeDTO save(EmployeeDTO dto);

	List<EmployeeDTO> findAll();

}
