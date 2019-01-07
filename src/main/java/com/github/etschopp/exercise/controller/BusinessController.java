package com.github.etschopp.exercise.controller;

import com.github.etschopp.exercise.domain.Business;
import com.github.etschopp.exercise.service.BusinessService;

import javax.persistence.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/businesses")
public class BusinessController {

    private BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/list")
    public Iterable<Business> list() {
        return businessService.list();
    }
}