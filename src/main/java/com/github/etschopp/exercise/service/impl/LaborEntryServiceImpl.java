package com.github.etschopp.exercise.service.impl;

import com.github.etschopp.exercise.domain.LaborEntry;
import com.github.etschopp.exercise.repository.LaborEntryRepository;
import com.github.etschopp.exercise.service.LaborEntryService;

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
public class LaborEntryServiceImpl implements LaborEntryService{

    private LaborEntryRepository laborEntryRepository;

    public Iterable<LaborEntry> list() {
        return laborEntryRepository.findAll();
    }

    public LaborEntry save(LaborEntry laborEntry) {
        return laborEntryRepository.save(laborEntry);
    }
	
	public List<LaborEntry> getLaborEntriesByEmployee (UUID employee_id) 
    {
        List<LaborEntry> laborEntriesByEmployeeID = new ArrayList<LaborEntry>();
        list().forEach(laborEntriesByEmployeeID::add);
        return laborEntriesByEmployeeID.stream().filter(e -> e.getEmployee_id().equals(employee_id)).collect(Collectors.toList());
    }

}