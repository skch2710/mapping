package com.springboot.mapping.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	
	@NotNull(message = "first name should't be null") //it takes empty arg & white space
	private String firstName;
	@NotBlank(message = "last name should't be blank") //it did't takes empty arg & white space
	private String lastName;
	@Valid
	private EmployeeDetailsDTO employeeDetails;
	@Valid
	private List<EmployeeAddressDTO> employeeAddressDTOs;
	
}
