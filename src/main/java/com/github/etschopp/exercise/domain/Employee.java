package com.github.etschopp.exercise.domain;


import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.*;
import javax.persistence.*;


@Data
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID business_id;
    private String first_name;
    private String last_name;
    private double pay_rate;
    private String updated_at;
    private String created_at;

    public Employee () {}
}

