package com.microservicio.springboot.reto.dao;

import org.springframework.data.repository.CrudRepository;

import com.microservicio.springboot.reto.models.Customer;

public interface ICustomerDao extends CrudRepository<Customer, Long>
{

}
