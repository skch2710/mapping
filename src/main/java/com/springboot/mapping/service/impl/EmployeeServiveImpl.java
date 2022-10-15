package com.springboot.mapping.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.mapping.dao.EmployeeAddressDAO;
import com.springboot.mapping.dao.EmployeeDAO;
import com.springboot.mapping.dto.EmployeeAddressDTO;
import com.springboot.mapping.dto.EmployeeDTO;
import com.springboot.mapping.dto.Result;
import com.springboot.mapping.exception.CustomException;
import com.springboot.mapping.model.Employee;
import com.springboot.mapping.model.EmployeeAddress;
import com.springboot.mapping.model.EmployeeDetails;
import com.springboot.mapping.service.EmployeeService;

@Service
public class EmployeeServiveImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private EmployeeAddressDAO employeeAddressDAO;

	@Override
	public Result findAll() {

		Result result = null;

		List<Employee> employees = employeeDAO.findAll();

		result = new Result(employees);
		result.setStatusCode(HttpStatus.OK.value());
		result.setSuccessMessage("fetching successfully.");

		return result;
	}

	@Override
	public Result save(EmployeeDTO employeeDTO) {

		Result result = null;

		try {

			Employee employee = new Employee();

			employee.setCreatedDate(new Date());
			employee.setFirstName(employeeDTO.getFirstName());
			employee.setLastName(employeeDTO.getLastName());

			EmployeeDetails employeeDetails = new EmployeeDetails();

			employeeDetails.setEmailId(employeeDTO.getEmployeeDetails().getEmailId());
			employeeDetails.setSalary(employeeDTO.getEmployeeDetails().getSalary());
			employeeDetails.setMobileNumber(Long.parseLong(employeeDTO.getEmployeeDetails().getMobileNumber()));

			employee.setEmployeeDetails(employeeDetails);

			List<EmployeeAddress> employeeAddressesList = new ArrayList<>();

			for (EmployeeAddressDTO employeeAddressDTO : employeeDTO.getEmployeeAddressDTOs()) {

				EmployeeAddress employeeAddress = new EmployeeAddress();

				employeeAddress.setAddressType(employeeAddressDTO.getAddressType());
				employeeAddress.setZipCode(Long.parseLong(employeeAddressDTO.getZipCode()));
				employeeAddress.setCity(employeeAddressDTO.getCity());
				employeeAddress.setState(employeeAddressDTO.getState());

				employeeAddressesList.add(employeeAddress);

				employeeAddress.setEmployee(employee);
			}

			employee.setEmployeeAddress(employeeAddressesList);

			Employee savedEmployee = employeeDAO.save(employee);

			result = new Result(savedEmployee);
			result.setStatusCode(HttpStatus.OK.value());
			result.setSuccessMessage("Saved Successfully.");

		} catch (Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

	@Override
	public Result delete(Long empId) {

		Result result = null;

		try {

			Employee employee = employeeDAO.findByEmpId(empId);
//			List<EmployeeAddress> employeeAddressList= employee.getEmployeeAddress();
//			for (EmployeeAddress employeeAddress : employee.getEmployeeAddress()) {
//				employeeAddress.setEmployee(null);
//			}
			employee.getEmployeeAddress().forEach(employeeAddress -> {
				employeeAddress.setEmployee(null);
			});
			employeeDAO.deleteById(empId);

			result = new Result();
			result.setStatusCode(HttpStatus.OK.value());
			result.setSuccessMessage("Delete Successfully.");

		} catch (Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return result;
	}

	@Override
	public Result findByEmpId(Long empId) {
		Result result = new Result();
		try {
			Employee employee = employeeDAO.findByEmpId(empId);
			if (employee == null) {
				result.setStatusCode(HttpStatus.NOT_FOUND.value());
				result.setErrorMessage("Employee Id not found :" + empId);
				result.setSuccessMessage(HttpStatus.NOT_FOUND.name());
			} else {
				result.setData(employee);
				result.setStatusCode(HttpStatus.OK.value());
				result.setSuccessMessage("Employee getiing successfully.");
			}
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

}
