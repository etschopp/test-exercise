package com.github.etschopp.exercise.repository;

import com.github.etschopp.exercise.domain.Checkk;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface CheckRepository extends CrudRepository<Checkk, UUID> {}