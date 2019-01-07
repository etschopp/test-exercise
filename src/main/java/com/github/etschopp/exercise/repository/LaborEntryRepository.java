package com.github.etschopp.exercise.repository;

import com.github.etschopp.exercise.domain.LaborEntry;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface LaborEntryRepository extends CrudRepository<LaborEntry, UUID> {}