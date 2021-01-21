package com.techbasevn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techbasevn.dto.EmployeeDTO;
import com.techbasevn.entity.EmployeeEntity;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	Optional<EmployeeEntity> findByName(String name);
	
	
	@Query("SELECT new com.techbasevn.dto.EmployeeDTO(id,name,address,age,email"
			+ ",gender,phone,position,salary) FROM EmployeeEntity")
	List<EmployeeDTO> getAll();
}
