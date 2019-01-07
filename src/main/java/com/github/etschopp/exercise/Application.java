package com.github.etschopp.exercise;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.github.etschopp.exercise.domain.Business;
import com.github.etschopp.exercise.domain.Checkk;
import com.github.etschopp.exercise.domain.Employee;
import com.github.etschopp.exercise.domain.LaborEntry;
import com.github.etschopp.exercise.domain.MenuItem;
import com.github.etschopp.exercise.domain.OrderedItem;

import com.github.etschopp.exercise.service.BusinessService;
import com.github.etschopp.exercise.service.CheckService;
import com.github.etschopp.exercise.service.EmployeeService;
import com.github.etschopp.exercise.service.LaborEntryService;
import com.github.etschopp.exercise.service.MenuItemService;
import com.github.etschopp.exercise.service.OrderedItemService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Bean
        @Order(1)
	CommandLineRunner businessRunner(BusinessService businessService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Business>> typeReference = new TypeReference<List<Business>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/businesses.json");
			try {
				List<Business> businesses = mapper.readValue(inputStream,typeReference);
                                businesses.forEach(business -> businessService.save(business));
				log.info("businesses Saved!");
			} catch (IOException e){
				log.error("Unable to save businesses: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner checkRunner(CheckService checkService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Checkk>> typeReference = new TypeReference<List<Checkk>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/checks.json");
			try {
				List<Checkk> checks = mapper.readValue(inputStream,typeReference);
                                checks.forEach(check -> checkService.save(check));
				log.info("checks Saved!");
			} catch (IOException e){
				log.error("Unable to save checks: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner employeeRunner(EmployeeService employeeService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Employee>> typeReference = new TypeReference<List<Employee>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/employees.json");
			try {
				List<Employee> employees = mapper.readValue(inputStream,typeReference);
                                employees.forEach(employee -> employeeService.save(employee));
				log.info("employees Saved!");
			} catch (IOException e){
				log.error("Unable to save employees: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner laborEntryRunner(LaborEntryService laborEntryService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<LaborEntry>> typeReference = new TypeReference<List<LaborEntry>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/laborEntries.json");
			try {
				List<LaborEntry> laborEntries = mapper.readValue(inputStream,typeReference);
                                laborEntries.forEach(laborEntry -> laborEntryService.save(laborEntry));
				log.info("labor entries Saved!");
			} catch (IOException e){
				log.error("Unable to save labor entries: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner menuItemRunner(MenuItemService menuItemService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<MenuItem>> typeReference = new TypeReference<List<MenuItem>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/menuItems.json");
			try {
				List<MenuItem> menuItems= mapper.readValue(inputStream,typeReference);
                                menuItems.forEach(menuItem -> menuItemService.save(menuItem));
				log.info("menu items Saved!");
			} catch (IOException e){
				log.error("Unable to save menu items: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner orderedItemRunner(OrderedItemService orderedItemService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<OrderedItem>> typeReference = new TypeReference<List<OrderedItem>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/orderedItems.json");
			try {
				List<OrderedItem> orderedItems= mapper.readValue(inputStream,typeReference);
                                orderedItems.forEach(orderedItem -> orderedItemService.save(orderedItem));
				log.info("ordered items Saved!");
			} catch (IOException e){
				log.error("Unable to save ordered items: " + e.getMessage());
			}
		};
	}
}