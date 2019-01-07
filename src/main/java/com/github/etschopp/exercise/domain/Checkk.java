package com.github.etschopp.exercise.domain;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.*;
import javax.persistence.*;


@Data
@AllArgsConstructor
@Entity
public class Checkk {

    // Use the word Checkk, as 'Check" is a SQL reserved word, and causes problems for Spring Data
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID business_id;
    private UUID employee_id;
    private String name;
    private boolean closed;
    private String closed_at;
    private String updated_at;
    private String created_at;

    public Checkk () {}
}