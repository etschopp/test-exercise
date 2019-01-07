package com.github.etschopp.exercise.service.impl;

import com.github.etschopp.exercise.domain.Employee;
import com.github.etschopp.exercise.repository.EmployeeRepository;
import com.github.etschopp.exercise.service.EmployeeService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public Iterable<Employee> list() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees (UUID business_id) 
    {
        List<Employee> employeesByBusinessID = new ArrayList<Employee>();
        list().forEach(employeesByBusinessID::add);
        return employeesByBusinessID.stream().filter(e -> e.getBusiness_id().equals(business_id)).collect(Collectors.toList());
    }

}