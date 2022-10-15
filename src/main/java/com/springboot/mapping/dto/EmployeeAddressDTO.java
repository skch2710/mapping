package com.springboot.mapping.dto;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAddressDTO {

	private String addressType;
	
	@Pattern(regexp = "^\\d{6}$",message="Enter valid zipcode")
	private String zipCode;

	private String state;

	private String city;

}
