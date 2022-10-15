package com.springboot.mapping.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;

	private String firstName;

	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

//	@OneToOne(cascade = CascadeType.ALL)
	// It will automatically delete employee details also in cascade=ALL
	 @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE,
	 CascadeType.PERSIST, CascadeType.REFRESH })
	// It will automatically delete only employee.
	@JoinColumn(name = "emp_details_id")
	private EmployeeDetails employeeDetails;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	// It will automatically delete employee address also in cascade=ALL
	private List<EmployeeAddress> employeeAddress;
}
