package com.github.etschopp.exercise.service.impl;

import com.github.etschopp.exercise.domain.Business;
import com.github.etschopp.exercise.repository.BusinessRepository;
import com.github.etschopp.exercise.service.BusinessService;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class BusinessServiceImpl implements BusinessService {

    private BusinessRepository businessRepository;

    public Iterable<Business> list() {
        return businessRepository.findAll();
    }

    public Business save(Business business) {
        return businessRepository.save(business);
    }

}