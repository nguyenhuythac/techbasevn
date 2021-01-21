package com.techbasevn.challenge.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.techbasevn.entity.DepartEntity;
import com.techbasevn.entity.TeamEntity;
import com.techbasevn.repository.DepartRepository;
import com.techbasevn.repository.TeamRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class TeamRepositoryTest {
	@Autowired
	private TeamRepository repository;
	
	@Autowired
	private DepartRepository departRepository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testSaveTeam() {
		TeamEntity team=new TeamEntity(null,"Team 361");
		DepartEntity depart=new DepartEntity(null,"phòng 20");
		DepartEntity savedDepart=departRepository.save(depart);
		team.setDepart(savedDepart);
		TeamEntity savedTeam=repository.save(team);
		assertNotNull(savedTeam);
	}
	
	@Test
	@Order(2)
	public void testFindTeamByIdExist() {
		String name="Team 361";
		Optional<TeamEntity> team=repository.findByName(name);
		assertThat(team.get().getName()).isEqualTo(name);
	}
	@Test
	@Order(3)
	public void testFindTeamByIdNotExist() {
		String name="Team 200";
		Optional<TeamEntity> team=repository.findByName(name);
		assertFalse(team.isPresent());
	}
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testUpdateTeam() {
		String name="Team 515";
		TeamEntity team=new TeamEntity(1,name);
		TeamEntity updatedTeam=repository.save(team);
		assertThat(updatedTeam.getName()).isEqualTo(name);
	}
	
	
	@Test
	@Order(5)
	public void testListTeam() {
		List<TeamEntity> teams=repository.findAll();
		teams.forEach(e->System.out.println(e.toString()));
		assertThat(teams).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(6)
	public void testDeleteTeam() {
		int id=1;
		boolean isExistBeforeDelete=repository.findById(id).isPresent();
		
		repository.deleteById(id);
		
		boolean notExistAfterDelete=repository.findById(id).isPresent();
		
		assertTrue(isExistBeforeDelete);
		assertFalse(notExistAfterDelete);
	}
}
