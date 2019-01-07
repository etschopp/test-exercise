package com.github.etschopp.exercise.repository;

import com.github.etschopp.exercise.domain.Business;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface BusinessRepository extends CrudRepository<Business, UUID> {}