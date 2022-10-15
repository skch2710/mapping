package com.springboot.mapping.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name = "employee_details")
//@JsonIgnoreProperties(ignoreUnknown = true, value = { "employee" })
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empDetailsId;

	private Double salary;

	private String emailId;
	
	private Long mobileNumber;
	
	@JsonIgnore
	@OneToOne(mappedBy = "employeeDetails", fetch = FetchType.LAZY)
	private Employee employee;
	
}
