package com.springboot.mapping.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name = "employee_address")
@JsonIgnoreProperties(ignoreUnknown = true, value = "employee")
public class EmployeeAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empAddressId;

	private String addressType;

	private Long zipCode;

	private String state;

	private String city;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_id", nullable = true)
	private Employee employee;
}
