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
import com.techbasevn.entity.DepartEntity;
import com.techbasevn.repository.DepartRepository;
import com.techbasevn.service.IDepartService;
@Service
public class DepartService implements IDepartService{
	@Autowired private DepartRepository departRepository;

	@Autowired ModelMapper modelMapper;
	
	@Autowired MapList<DepartDTO, DepartEntity> mapList;
	
	@Override
	@Transactional
	public DepartDTO save(DepartDTO dto) {
		DepartEntity entity=modelMapper.map(dto,DepartEntity.class);
		return modelMapper.map(departRepository.save(entity),DepartDTO.class);
	}

	@Override
	public List<DepartDTO> findAll(Pageable pageable) {
		return mapList.toDtos(departRepository
				.findAll(pageable).getContent(), DepartDTO.class);
	}

	@Override
	public List<DepartDTO> findAll() {
		return mapList.toDtos(departRepository.findAll(), DepartDTO.class);
	}

	@Override
	public Optional<DepartDTO> findById(Integer id) {
		return Optional.ofNullable(modelMapper
				.map(departRepository.findById(id),DepartDTO.class));
	}

	@Override
	public boolean existsById(Integer id) {
		return departRepository.existsById(id);
	}

	@Override
	public DepartDTO getOne(Integer id) {
		return (modelMapper
				.map(departRepository.getOne(id),DepartDTO.class));
	}

	@Override
	public long count() {
		return departRepository.count();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		departRepository.deleteById(id);
	}
	
	
}
