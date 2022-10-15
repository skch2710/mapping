package com.springboot.mapping.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * This Model/Entity class mapped with a master tale / Base table.
 */

@Data
@Entity
@Table(name = "course")
public class Course {

	@Id
	private Long courseId;

	private String courseName;

	private String duration;

	private Double fee;
}
