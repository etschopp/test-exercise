package com.github.etschopp.exercise.repository;

import com.github.etschopp.exercise.domain.Employee;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, UUID> {}