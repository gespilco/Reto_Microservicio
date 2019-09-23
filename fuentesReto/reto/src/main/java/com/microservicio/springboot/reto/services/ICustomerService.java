package com.microservicio.springboot.reto.services;

import java.util.List;

import com.microservicio.springboot.reto.models.Customer;

public interface ICustomerService {
	public Customer create(Customer customer);

	public List<Customer> getCustomers();
	
	public Customer findById(Long id);
}
