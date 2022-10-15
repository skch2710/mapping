package com.springboot.mapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mapping.dto.Result;
import com.springboot.mapping.dto.StudentDTO;
import com.springboot.mapping.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<Result> saveStudent(@RequestBody StudentDTO studentDTO) {
		return ResponseEntity.ok(studentService.save(studentDTO));
	}

	@GetMapping("/getAllStudents")
	public ResponseEntity<Result> getAllStudents() {
		return ResponseEntity.ok(studentService.findAll());
	}

	@DeleteMapping("/deleteById/{studentId}")
	public ResponseEntity<Result> deleteById(@PathVariable Long studentId) {
		return ResponseEntity.ok(studentService.deleteById(studentId));
	}

}
