package com.springboot.mapping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.mapping.model.EmployeeDetails;

public interface EmployeeDetailsDAO extends JpaRepository<EmployeeDetails, Long> {

}
