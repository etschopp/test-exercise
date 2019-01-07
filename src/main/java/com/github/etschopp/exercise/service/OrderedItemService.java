package com.github.etschopp.exercise.service;

import com.github.etschopp.exercise.domain.OrderedItem;
import com.github.etschopp.exercise.repository.OrderedItemRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public interface OrderedItemService {

    public Iterable<OrderedItem> list();

    public List<OrderedItem> getOrderedItems(UUID check_id);

    public OrderedItem save(OrderedItem orderedItem);

}