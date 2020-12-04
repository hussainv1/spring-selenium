package com.udemy.spring.springselenium.condition;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;

public class CarTest extends SpringBaseTestNGTest{
	
	@Autowired
	private Car car;
	
	
	@Test
	public void carTest() {
		this.car.run();
	}

}
