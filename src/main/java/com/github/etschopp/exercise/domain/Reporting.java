package com.github.etschopp.exercise.domain;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reporting {

    private UUID business_id;
    private String report;
    private String timeInterval;
    private String start;
    private String end;
    //private String report;
    //private String timeInterval;
    //private List<Data> data;

}