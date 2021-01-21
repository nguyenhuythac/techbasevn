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

import com.techbasevn.dto.EmployeeDTO;
import com.techbasevn.entity.EmployeeEntity;
import com.techbasevn.repository.EmployeeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class EmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository repository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testSaveEployee() {
		EmployeeEntity employee=new EmployeeEntity(null,"Hà Lê","pleiku",29
				,"nguyenhuythac@gmail.com","nam","0913223456","Giám đốc",(long)33000000);
		EmployeeEntity savedEmployee=repository.save(employee);
		assertNotNull(savedEmployee);
	}
	
	@Test
	@Order(2)
	public void testFindEmployeeByIdExist() {
		String name="Hà Lê";
		Optional<EmployeeEntity> employee=repository.findByName(name);
		assertThat(employee.get().getName()).isEqualTo(name);
	}
	@Test
	@Order(3)
	public void testFindEmployeeByIdNotExist() {
		String name="Ngô Tất Tố";
		Optional<EmployeeEntity> employee=repository.findByName(name);
		assertFalse(employee.isPresent());
	}
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testUpdateEployee(){
		String name="Hoàng Nam";
		EmployeeEntity employee=new EmployeeEntity(9,name,"pleiku",29
				,"hoangnam@gmail.com","nam","09134444","Nhân viên",(long)40000000);
		EmployeeEntity updatedEmployee=repository.save(employee);
		assertThat(updatedEmployee.getName()).isEqualTo(name);
	}
	
	
	@Test
	@Order(5)
	public void testListEmployee() {
		List<EmployeeDTO> employees=repository.getAll();
		employees.forEach(e->System.out.println(e.toString()));
		assertThat(employees).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(6)
	public void testDeleteProduct() {
		int id=1;
		boolean isExistBeforeDelete=repository.findById(id).isPresent();
		
		repository.deleteById(id);
		
		boolean notExistAfterDelete=repository.findById(id).isPresent();
		
		assertTrue(isExistBeforeDelete);
		assertFalse(notExistAfterDelete);
	}
}
