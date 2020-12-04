package com.udemy.spring.springselenium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class User {

	@Autowired
	private Address address;
	
	@Autowired
	private Salary salary;
	
	@Autowired
	private Faker faker;
	
	
	/**

	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	@Autowired
	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	**/
	
	
	public void printDetails() {
		System.out.println("Address: " + this.address.getStreet());
		System.out.println("Salary: " + this.salary.getAmount());
		System.out.println("Name: " + this.faker.name().fullName());
	}
}
