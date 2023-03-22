package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.UpdateEmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepositiry;
	
	@Autowired
	UpdateEmployeeRepository updateEmployeeRepository;

	public Employee createEmployee(Employee employee) {
		return employeeRepositiry.save(employee);
	}
	
	public void updatePhoneNumber(String firstName, String newPhoneNumber) {
		updateEmployeeRepository.updatePhoneNumber(firstName, newPhoneNumber);
	}
	
	public Integer getEmployeesCountByFirstName(String firstName) {
		return updateEmployeeRepository.getEmployeesCountByFirstName(firstName);
	}

}
