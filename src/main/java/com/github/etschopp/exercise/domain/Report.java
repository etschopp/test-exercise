package com.github.etschopp.exercise.domain;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Report {

    private String report;
    private String timeInterval;
    private List<ReportData> data;

}