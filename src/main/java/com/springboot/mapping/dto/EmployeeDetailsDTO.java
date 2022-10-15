package com.springboot.mapping.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailsDTO {
	
	@Min(value = 10000,message = "min 10,000 ")
	@Max(value = 200000,message = "max 2,00,000 ")
	private Double salary;
	@Email(message = "Invalid Email")
	private String emailId;
	@Pattern(regexp = "^\\d{10}$",message = "Invalid Mobile Number.")
	private String mobileNumber;

}
