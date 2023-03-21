package com.example.demo.repository;

import org.springframework.stereotype.Repository;

public interface UpdateEmployeeRepository {
	void updatePhoneNumber(String firstName, String newPhoneNumber);
}
