package com.techbasevn.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techbasevn.converter.MapList;
import com.techbasevn.dto.DepartDTO;
import com.techbasevn.dto.EmployeeDTO;
import com.techbasevn.entity.DepartEntity;
import com.techbasevn.entity.EmployeeEntity;
import com.techbasevn.repository.EmployeeRepository;
import com.techbasevn.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	MapList<DepartDTO, DepartEntity> mapList;

	@Override
	@Transactional
	public EmployeeDTO save(EmployeeDTO dto) {
		EmployeeEntity entity = modelMapper.map(dto, EmployeeEntity.class);
		return modelMapper.map(employeeRepository.save(entity), EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> findAll(Pageable pageable) {
		return mapList.toDtos(employeeRepository.findAll(pageable).getContent(), EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> findAll() {
		return mapList.toDtos(employeeRepository.findAll(), EmployeeDTO.class);
	}

	@Override
	public Optional<EmployeeDTO> findById(Integer id) {
		return Optional.ofNullable(modelMapper
				.map(employeeRepository.findById(id), EmployeeDTO.class));
	}

	@Override
	public boolean existsById(Integer id) {
		return employeeRepository.existsById(id);
	}

	@Override
	public EmployeeDTO getOne(Integer id) {
		return (modelMapper.map(employeeRepository.getOne(id), EmployeeDTO.class));
	}

	@Override
	public long count() {
		return employeeRepository.count();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		employeeRepository.deleteById(id);
	}

}
