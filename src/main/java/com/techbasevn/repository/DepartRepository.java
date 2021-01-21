package com.techbasevn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbasevn.entity.DepartEntity;
@Repository
public interface DepartRepository extends JpaRepository<DepartEntity, Integer>{
	Optional<DepartEntity> findByName(String name);
}
