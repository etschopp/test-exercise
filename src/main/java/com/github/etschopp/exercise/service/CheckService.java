package com.github.etschopp.exercise.service;

import com.github.etschopp.exercise.domain.Checkk;
import com.github.etschopp.exercise.repository.CheckRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public interface CheckService {

    public Iterable<Checkk> list();

    public List<Checkk> getChecksByEmployee (UUID employee_id);
	
	//public List<Checkk> getChecksByBusiness (UUID business_id);

    public Checkk save(Checkk check);

}