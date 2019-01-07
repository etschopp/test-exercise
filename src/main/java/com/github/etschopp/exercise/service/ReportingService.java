package com.github.etschopp.exercise.service;

import com.github.etschopp.exercise.domain.Report;


import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public interface ReportingService {

    public Report generateReport(UUID business_id, String report, String timeInterval, String start, String end);

}