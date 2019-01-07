package com.github.etschopp.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportData {

    private TimeFrame timeFrame;
    private double value;

}