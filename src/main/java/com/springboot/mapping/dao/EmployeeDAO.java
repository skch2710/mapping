package com.springboot.mapping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.mapping.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {
	
	Employee findByEmpId(Long empId);

}
