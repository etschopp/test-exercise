package com.github.etschopp.exercise.controller;

import com.github.etschopp.exercise.domain.Checkk;
import com.github.etschopp.exercise.service.CheckService;

import javax.persistence.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checks")
public class CheckController {

    private CheckService checkService;

    public CheckController(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping("/list")
    public Iterable<Checkk> list() {
        return checkService.list();
    }
}