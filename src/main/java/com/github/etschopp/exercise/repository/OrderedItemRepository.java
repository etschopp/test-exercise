package com.github.etschopp.exercise.repository;

import com.github.etschopp.exercise.domain.OrderedItem;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface OrderedItemRepository extends CrudRepository<OrderedItem, UUID> {}