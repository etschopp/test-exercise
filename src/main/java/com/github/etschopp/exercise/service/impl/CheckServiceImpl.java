package com.github.etschopp.exercise.service.impl;

import com.github.etschopp.exercise.domain.Checkk;
import com.github.etschopp.exercise.repository.CheckRepository;
import com.github.etschopp.exercise.service.CheckService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class CheckServiceImpl implements CheckService {

    private CheckRepository checkRepository;

    public Iterable<Checkk> list() {
        return checkRepository.findAll();
    }

    public Checkk save(Checkk check) {
        return checkRepository.save(check);
    }

    public List<Checkk> getChecksByEmployee (UUID employee_id) 
    {
        List<Checkk> checksByEmployeeID = new ArrayList<Checkk>();
        list().forEach(checksByEmployeeID::add);
        return checksByEmployeeID.stream().filter(e -> e.getEmployee_id().equals(employee_id)).collect(Collectors.toList());
    }
	
    //public List<Checkk> getChecksByBusiness (UUID business_id) 
    //{
    //    List<Checkk> checksByBusiness = new ArrayList<Checkk>();
    //    list().forEach(checksByBusiness::add);
    //    return checksByBusiness.stream().filter(e -> e.getBusiness_id().equals(business_id)).collect(Collectors.toList());
    //}

}