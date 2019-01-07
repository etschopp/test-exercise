package com.github.etschopp.exercise.service;

import com.github.etschopp.exercise.domain.LaborEntry;
import com.github.etschopp.exercise.repository.LaborEntryRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public interface LaborEntryService {

    public Iterable<LaborEntry> list();
	
	public List<LaborEntry> getLaborEntriesByEmployee (UUID employee_id);

    public LaborEntry save(LaborEntry laborEntry);

}