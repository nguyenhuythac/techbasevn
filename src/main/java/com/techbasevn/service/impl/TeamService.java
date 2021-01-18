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
import com.techbasevn.dto.TeamDTO;
import com.techbasevn.entity.DepartEntity;
import com.techbasevn.entity.TeamEntity;
import com.techbasevn.repository.TeamRepository;
import com.techbasevn.service.ITeamService;

@Service
public class TeamService implements ITeamService {
	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	MapList<DepartDTO, DepartEntity> mapList;

	@Override
	@Transactional
	public TeamDTO save(TeamDTO dto) {
		TeamEntity entity = modelMapper.map(dto, TeamEntity.class);
		return modelMapper.map(teamRepository.save(entity), TeamDTO.class);
	}

	@Override
	public List<TeamDTO> findAll(Pageable pageable) {
		return mapList.toDtos(teamRepository.findAll(pageable).getContent(), TeamDTO.class);
	}

	@Override
	public List<TeamDTO> findAll() {
		return mapList.toDtos(teamRepository.findAll(), TeamDTO.class);
	}

	@Override
	public Optional<TeamDTO> findById(Integer id) {
		return Optional.ofNullable(modelMapper.map(teamRepository.findById(id), TeamDTO.class));
	}

	@Override
	public boolean existsById(Integer id) {
		return teamRepository.existsById(id);
	}

	@Override
	public TeamDTO getOne(Integer id) {
		return (modelMapper.map(teamRepository.getOne(id), TeamDTO.class));
	}

	@Override
	public long count() {
		return teamRepository.count();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		teamRepository.deleteById(id);
	}

}
