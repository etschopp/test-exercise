package com.github.etschopp.exercise.controller;

import com.github.etschopp.exercise.domain.Employee;
import com.github.etschopp.exercise.service.EmployeeService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method=RequestMethod.GET, path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Employee> getEmployees (@RequestParam(value="business_id") UUID business_id) 
    {
        return employeeService.getEmployees(business_id);
        //List<Employee> employeesByBusinessID = new ArrayList<Employee>();
        //employeeService.list().forEach(employeesByBusinessID::add);
        //return employeesByBusinessID.stream().filter(e -> e.getBusiness_id().equals(business_id)).collect(Collectors.toList());
    }
}