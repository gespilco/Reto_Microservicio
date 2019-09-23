package com.microservicio.springboot.reto.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer{

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@Column(name = "name", nullable = true)
	private String name;
	
	@Column(name = "lastName", nullable = true)
	private String lastName;

	
	@Column(name = "age", nullable = true)
	private int age;

	@Column(name = "birth", nullable = true)
	private Date birth;
	
	private Date deadDate;
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Date getBirth() {
		return birth;
	}
	
	public long getId() {
		return id;
	}
	
	public Date getDeadDate() {
		return deadDate;
	}
	
	public void setDeadDate(Date deadDate) {
		this.deadDate = deadDate;
	}
	
 
}
