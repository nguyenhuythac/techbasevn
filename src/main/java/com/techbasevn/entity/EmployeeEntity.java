package com.techbasevn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class EmployeeEntity extends BaseEntity {

	@Column(length = 3)
	private Integer age;

	@Column(length = 5)
	private String gender;

	@Column(length = 40)
	private String email;

	@Column
	private String address;

	@Column
	private String phone;

	@Column
	private String position;

	@Column
	private Long salary;

	@ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	private List<TeamEntity> teams;

	public EmployeeEntity() {
	}

	public EmployeeEntity(Integer id, String name) {
		super(id, name);
	}

	public EmployeeEntity(Integer id, String name, String address, Integer age, String email, String gender,
			String phone, String position, Long salary) {
		super(id, name);
		this.address = address;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		this.position = position;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [age=" + age + ", gender=" + gender + ", email=" + email + ", address=" + address
				+ ", phone=" + phone + ", position=" + position + ", salary=" + salary + ", teams=" + teams + "]";
	}

}
