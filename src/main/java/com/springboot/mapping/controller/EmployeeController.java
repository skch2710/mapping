package com.springboot.mapping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mapping.dto.EmployeeDTO;
import com.springboot.mapping.dto.Result;
import com.springboot.mapping.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAll")
	public Result getAll() {

		Result result = employeeService.findAll();

		return result;
	}

	@PostMapping("/save")
	public ResponseEntity<Result> save(@Valid @RequestBody EmployeeDTO employeeDTO) {

		Result result = employeeService.save(employeeDTO);

		return new ResponseEntity<>(result, HttpStatus.OK);

	}
	
	@DeleteMapping("/deleteById/{empId}")
	public ResponseEntity<Result> delete(@PathVariable Long empId) {
		
		Result result = employeeService.delete(empId);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/getByEmpId/{empId}")
	public ResponseEntity<Result> findByEmpId(@PathVariable Long empId){
		return ResponseEntity.ok(employeeService.findByEmpId(empId));
	}
}
