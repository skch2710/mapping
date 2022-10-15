package com.springboot.mapping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.mapping.model.EmployeeAddress;

@Repository
public interface EmployeeAddressDAO extends JpaRepository<EmployeeAddress, Long> {

	@Query(value ="SELECT * FROM employee_address WHERE emp_id = :empId" , nativeQuery = true)
	List<EmployeeAddress> findByEmpId(@Param("empId") Long empId);

}
