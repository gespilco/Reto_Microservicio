package com.microservicio.springboot.reto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicio.springboot.reto.dao.ICustomerDao;
import com.microservicio.springboot.reto.models.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService
{
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public Customer create(Customer customer) {
		System.out.println(customer.getName());
		Customer createCustomer=customerDao.save(customer);
		return createCustomer;
	}

	@Override
	public List<Customer> getCustomers() {
		return (List<Customer>) customerDao.findAll();
	}

	@Override
	public Customer findById(Long id) {
		return customerDao.findById(id).orElse(null);
	}

}
