package com.techbasevn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;

import com.techbasevn.dto.TeamDTO;

public interface ITeamService {

	void deleteById(Integer id);

	long count();

	TeamDTO getOne(Integer id);

	boolean existsById(Integer id);

	Optional<TeamDTO> findById(Integer id);

	List<TeamDTO> findAll();

	List<TeamDTO> findAll(Pageable pageable);

	TeamDTO save(TeamDTO dto);

	Optional<TeamDTO> findByName(String name);
	
}
