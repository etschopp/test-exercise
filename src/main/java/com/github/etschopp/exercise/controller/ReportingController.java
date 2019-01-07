package com.github.etschopp.exercise.controller;


import com.github.etschopp.exercise.domain.Report;
import com.github.etschopp.exercise.domain.Reporting;
import com.github.etschopp.exercise.service.ReportingService;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingController {


    private ReportingService reportingService;

    public ReportingController(ReportingService reportingService) {
        this.reportingService = reportingService;
    }

    @RequestMapping(method=RequestMethod.GET, path = "/reporting", produces = MediaType.APPLICATION_JSON_VALUE)
    public Report generateReport(@RequestParam(value="business_id") UUID business_id,
                                              @RequestParam(value="report") String report,
                                              @RequestParam(value="timeInterval") String timeInterval,
                                              @RequestParam(value="start") String start,
                                              @RequestParam(value="end") String end) 
    {
        return reportingService.generateReport(business_id, report, timeInterval, start, end);
    }

}