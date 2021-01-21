package com.techbasevn.challenge.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.techbasevn.dto.EmployeeDTO;
import com.techbasevn.entity.EmployeeEntity;
import com.techbasevn.repository.EmployeeRepository;
import com.techbasevn.service.impl.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	/*
	 * @TestConfiguration static class EmployeeServiceImplTestContextConfiguration {
	 * 
	 * @Bean public IEmployeeService iEmployeeService() { return new
	 * EmployeeService(); } }
	 */

	@InjectMocks
	private EmployeeService service;

	@Mock
	private EmployeeRepository repository;

	@Test
	public void findAllTest() throws ParseException {
		when(repository.getAll()).thenReturn(Stream.of(
				new EmployeeDTO(10, "Hà Lê", "TP.HCM", 29, "hale@gmail.com", "nữ", "0913223456", "Giám đốc",
						(long) 33000000),
				new EmployeeDTO(20, "Tenny", "pleiku", 30, "nguyenhuythac@gmail.com", "nam", "0906604279", "Nhân viên",
						(long) 20000000))
				.collect(Collectors.toList()));
		assertEquals(2, service.findAll().size());
	}
}
