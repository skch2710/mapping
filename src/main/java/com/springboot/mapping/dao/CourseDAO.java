package com.springboot.mapping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.mapping.model.Course;

public interface CourseDAO extends JpaRepository<Course, Long> {

}
