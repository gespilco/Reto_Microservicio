package com.microservicio.springboot.reto.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservicio.springboot.reto.models.Customer;
import com.microservicio.springboot.reto.services.ICustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private ICustomerService microservice;

	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> create(@RequestBody Customer customer) {
		Map<String, Object> response = new HashMap<>();
		try {
			Customer createCustomer = microservice.create(customer);
			return new ResponseEntity<Customer>(createCustomer, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder al objeto");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/statistics")
	public ResponseEntity<?> averageDesviation() {

		List<Customer> customers = microservice.getCustomers();
		int ages=0;
		for (Customer customer : customers) {
			ages=ages+customer.getAge();
		}
		double average=ages/customers.size();
		double sum=0;
		for (Customer customer : customers) {
			sum += Math.pow ( customer.getAge() - average, 2 );
		}
	    double deviation=  Math.sqrt ( sum / ( double ) customers.size());
	    Map<String, Object> response = new HashMap<>();
	    response.put("Average", average+"");
	    response.put("Standard Deviation", deviation+"");
	    return new ResponseEntity<Map>(response, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<?> customers() {
		List<Customer> customers = microservice.getCustomers();
		for (Customer customer : customers) {
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(customer.getBirth());
			calendar.add(Calendar.YEAR, 80);
			customer.setDeadDate(calendar.getTime());
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);	
	}
    
}
