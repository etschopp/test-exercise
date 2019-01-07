package com.github.etschopp.exercise.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.*;
import javax.persistence.*;


@Data
@AllArgsConstructor
@Entity
public class LaborEntry {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID business_id;
    private UUID employee_id;
    private String name;
    private String clock_in;
    private String clock_out;
    private double pay_rate;
    private String updated_at;
    private String created_at;

    public LaborEntry () {}
}

