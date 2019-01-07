package com.github.etschopp.exercise.service.impl;

import com.github.etschopp.exercise.domain.OrderedItem;
import com.github.etschopp.exercise.repository.OrderedItemRepository;
import com.github.etschopp.exercise.service.OrderedItemService;

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
public class OrderedItemServiceImpl implements OrderedItemService {

    private OrderedItemRepository orderedItemRepository;

    public Iterable<OrderedItem> list() {
        return orderedItemRepository.findAll();
    }

    public OrderedItem save(OrderedItem orderedItem) {
        return orderedItemRepository.save(orderedItem);
    }

    public List<OrderedItem> getOrderedItems (UUID check_id) 
    {
        List<OrderedItem> orderedItemsByCheckID = new ArrayList<OrderedItem>();
        list().forEach(orderedItemsByCheckID::add);
        return orderedItemsByCheckID.stream().filter(e -> e.getCheck_id().equals(check_id)).collect(Collectors.toList());
    }

}