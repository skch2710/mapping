package com.springboot.mapping.service;

import com.springboot.mapping.dto.Result;
import com.springboot.mapping.dto.StudentDTO;

public interface StudentService {
	
	public Result save(StudentDTO studentDTO);
	
	public Result findAll();
	
	public Result deleteById(Long studentId);

}
