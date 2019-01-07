package com.github.etschopp.exercise.service;

import com.github.etschopp.exercise.domain.Business;
import com.github.etschopp.exercise.repository.BusinessRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BusinessService {

    public Iterable<Business> list();

    public Business save(Business business);

}