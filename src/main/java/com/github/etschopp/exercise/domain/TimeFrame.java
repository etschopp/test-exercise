package com.github.etschopp.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimeFrame {

    private String start;
    private String end;

}