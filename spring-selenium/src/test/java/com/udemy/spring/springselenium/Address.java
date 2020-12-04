package com.udemy.spring.springselenium;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
	
	// field injection
	/** @Value("${street}")
	private String street;
	**/
	
	private String street;
	
	//setter injection
	@Value("${street}")
	private void setStreet(String street) {
		this.street = street;
	}

	
	public String getStreet() {
		return street;
	}

}
