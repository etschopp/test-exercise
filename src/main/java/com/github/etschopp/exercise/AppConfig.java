package com.github.etschopp.exercise;

import com.github.etschopp.exercise.repository.BusinessRepository;
import com.github.etschopp.exercise.repository.CheckRepository;
import com.github.etschopp.exercise.repository.EmployeeRepository;
import com.github.etschopp.exercise.repository.LaborEntryRepository;
import com.github.etschopp.exercise.repository.MenuItemRepository;
import com.github.etschopp.exercise.repository.OrderedItemRepository;

import com.github.etschopp.exercise.service.BusinessService;
import com.github.etschopp.exercise.service.CheckService;
import com.github.etschopp.exercise.service.EmployeeService;
import com.github.etschopp.exercise.service.LaborEntryService;
import com.github.etschopp.exercise.service.MenuItemService;
import com.github.etschopp.exercise.service.OrderedItemService;
import com.github.etschopp.exercise.service.ReportingService;

import com.github.etschopp.exercise.service.impl.BusinessServiceImpl;
import com.github.etschopp.exercise.service.impl.CheckServiceImpl;
import com.github.etschopp.exercise.service.impl.EmployeeServiceImpl;
import com.github.etschopp.exercise.service.impl.LaborEntryServiceImpl;
import com.github.etschopp.exercise.service.impl.MenuItemServiceImpl;
import com.github.etschopp.exercise.service.impl.OrderedItemServiceImpl;
import com.github.etschopp.exercise.service.impl.ReportingServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
 
    @Bean
    public BusinessService businessService(BusinessRepository businessRepository) {
        return new BusinessServiceImpl(businessRepository);
    }

    @Bean
    public CheckService checkService(CheckRepository checkRepository) {
        return new CheckServiceImpl(checkRepository);
    }

    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository) {
        return new EmployeeServiceImpl(employeeRepository);
    }

    @Bean
    public LaborEntryService laborEntryService(LaborEntryRepository laborEntryRepository) {
        return new LaborEntryServiceImpl(laborEntryRepository);
    }

    @Bean
    public MenuItemService menuItemService(MenuItemRepository menuItemRepository) {
        return new MenuItemServiceImpl(menuItemRepository);
    }

    @Bean
    public OrderedItemService orderedItemService(OrderedItemRepository orderedItemRepository) {
        return new OrderedItemServiceImpl(orderedItemRepository);
    }

    @Bean
    public ReportingService reportingService(CheckService checkService, EmployeeService employeeService, LaborEntryService laborEntryService, OrderedItemService orderedItemService) {
        return new ReportingServiceImpl(checkService, employeeService, laborEntryService, orderedItemService);
    }

}