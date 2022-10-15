package com.springboot.mapping.service;

import com.springboot.mapping.dto.EmployeeDTO;
import com.springboot.mapping.dto.Result;

public interface EmployeeService {
	
	public Result findAll(); 
	
	public Result save(EmployeeDTO employeeDTO);
	
	public Result delete(Long empId);
	
	public Result findByEmpId(Long empId);

}
