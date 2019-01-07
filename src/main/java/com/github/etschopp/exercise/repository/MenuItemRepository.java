package com.github.etschopp.exercise.repository;

import com.github.etschopp.exercise.domain.MenuItem;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepository extends CrudRepository<MenuItem, UUID> {}