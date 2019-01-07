package com.github.etschopp.exercise.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.*;
import javax.persistence.*;


@Data
@AllArgsConstructor
@Entity
public class Business {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private double[] hours;
    private String updated_at;
    private String created_at;

    public Business () {}
}