package com.techbasevn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.techbasevn.dto.DepartDTO;

public interface IDepartService {

	void deleteById(Integer id);

	long count();

	DepartDTO getOne(Integer id);

	boolean existsById(Integer id);

	Optional<DepartDTO> findById(Integer id);

	List<DepartDTO> findAll();

	List<DepartDTO> findAll(Pageable pageable);

	DepartDTO save(DepartDTO dto);

	Optional<DepartDTO> findByName(String name);

}
