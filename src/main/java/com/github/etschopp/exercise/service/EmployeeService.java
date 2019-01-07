package com.github.etschopp.exercise.service;

import com.github.etschopp.exercise.domain.Employee;
import com.github.etschopp.exercise.repository.EmployeeRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    public Iterable<Employee> list();

    public List<Employee> getEmployees(UUID business_id);

    public Employee save(Employee employee);

}