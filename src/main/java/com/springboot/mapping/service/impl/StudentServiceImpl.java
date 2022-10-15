package com.springboot.mapping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.mapping.dao.StudentDAO;
import com.springboot.mapping.dto.Result;
import com.springboot.mapping.dto.StudentDTO;
import com.springboot.mapping.exception.CustomException;
import com.springboot.mapping.model.Course;
import com.springboot.mapping.model.Student;
import com.springboot.mapping.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public Result save(StudentDTO studentDTO) {
		Result result = null;
		try {
			Student student = new Student();
			student.setFullName(studentDTO.getFullName());
			student.setEmailId(studentDTO.getEmailId());

			Course course = new Course();
			course.setCourseId(studentDTO.getCourseId());
			student.setCourse(course);

			Student serverStudent = studentDAO.save(student);
			result = new Result(serverStudent);
			result.setStatusCode(HttpStatus.OK.value());
			result.setSuccessMessage("Student added successfully");

		} catch (Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return result;
	}

	@Override
	public Result findAll() {
		Result result = null;
		try {

			List<Student> student = studentDAO.findAll();

			result = new Result(student);
			result.setStatusCode(HttpStatus.OK.value());
			result.setSuccessMessage("fetching All successfully.");

		} catch (Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

	@Override
	public Result deleteById(Long studentId) {

		Result result = new Result();
		try {

			studentDAO.deleteById(studentId);

			result.setStatusCode(HttpStatus.OK.value());
			result.setSuccessMessage("delete successfully.");

		} catch (Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return result;
	}

}
