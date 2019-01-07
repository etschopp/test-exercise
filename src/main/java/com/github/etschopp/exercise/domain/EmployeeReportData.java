package com.github.etschopp.exercise.domain;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data
//@NoArgsConstructor
public class EmployeeReportData extends ReportData {

    private String employee;

    public EmployeeReportData (TimeFrame timeFrame, double value, String employee) {
        super(timeFrame, value);
        this.employee = employee;
    }   
        

}