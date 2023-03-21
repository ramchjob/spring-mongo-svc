package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee e = employeeService.createEmployee(employee);
		return ResponseEntity.ok(e);
	}
	
	@GetMapping("/{firstName}/{phoneNumber}")
	public ResponseEntity<Void> updatePhoneNumber(@PathVariable("firstName") String firstName, @PathVariable("phoneNumber") String phoneNumber) {
		employeeService.updatePhoneNumber(firstName, phoneNumber);
		return ResponseEntity.ok().build();
	}

}
