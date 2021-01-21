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
import com.techbasevn.entity.EmployeeEntity;
import com.techbasevn.repository.DepartRepository;
import com.techbasevn.repository.EmployeeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class DepartRepositoryTest {
	@Autowired
	private DepartRepository repository;
	
	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testSaveDepart() {
		EmployeeEntity employee=new EmployeeEntity(null,"Quảng","pleiku",29
				,"nguyenhuythac@gmail.com","nam","0913223456","Trưởng phòng",(long)33000000);
		EmployeeEntity savedEmployee=EmployeeRepository.save(employee);
		DepartEntity depart=new DepartEntity(null,"Phòng 3");
		depart.setManager(savedEmployee);
		DepartEntity savedDepart=repository.save(depart);
		assertNotNull(savedDepart);
	}
	
	@Test
	@Order(2)
	public void testFindDepartByIdExist() {
		String name="Phòng 3";
		Optional<DepartEntity> depart=repository.findByName(name);
		assertThat(depart.get().getName()).isEqualTo(name);
	}
	@Test
	@Order(3)
	public void testFindDepartByIdNotExist() {
		String name="Phòng 4";
		Optional<DepartEntity> depart=repository.findByName(name);
		assertFalse(depart.isPresent());
	}
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testUpdateDepart() {
		String name="Phòng 5";
		DepartEntity depart=new DepartEntity(1,name);
		DepartEntity updatedDepart=repository.save(depart);
		assertThat(updatedDepart.getName()).isEqualTo(name);
	}
	
	
	@Test
	@Order(5)
	public void testListDepart() {
		List<DepartEntity> departs=repository.findAll();
		departs.forEach(e->System.out.println(e.toString()));
		assertThat(departs).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(6)
	public void testDeleteDepart() {
		int id=3;
		boolean isExistBeforeDelete=repository.findById(id).isPresent();
		
		repository.deleteById(id);
		
		boolean notExistAfterDelete=repository.findById(id).isPresent();
		
		assertTrue(isExistBeforeDelete);
		assertFalse(notExistAfterDelete);
	}
}
