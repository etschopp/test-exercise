package com.github.etschopp.exercise.service.impl;

import com.github.etschopp.exercise.domain.MenuItem;
import com.github.etschopp.exercise.repository.MenuItemRepository;
import com.github.etschopp.exercise.service.MenuItemService;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class MenuItemServiceImpl implements MenuItemService {

    private MenuItemRepository menuItemRepository;

    public Iterable<MenuItem> list() {
        return menuItemRepository.findAll();
    }

    public MenuItem save(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

}