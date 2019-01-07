package com.github.etschopp.exercise.service;

import com.github.etschopp.exercise.domain.MenuItem;
import com.github.etschopp.exercise.repository.MenuItemRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface MenuItemService {

    public Iterable<MenuItem> list();

    public MenuItem save(MenuItem menuItem);

}