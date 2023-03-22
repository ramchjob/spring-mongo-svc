package com.example.demo.repository;

public interface UpdateEmployeeRepository {
	void updatePhoneNumber(String firstName, String newPhoneNumber);
	Integer getEmployeesCountByFirstName(String firstName);
}
