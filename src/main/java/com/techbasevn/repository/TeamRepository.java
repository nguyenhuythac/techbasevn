package com.techbasevn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbasevn.entity.TeamEntity;
@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Integer>{
	Optional<TeamEntity> findByName(String name);
}
