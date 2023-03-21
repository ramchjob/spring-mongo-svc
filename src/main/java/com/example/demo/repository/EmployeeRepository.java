package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, UUID> {

}
