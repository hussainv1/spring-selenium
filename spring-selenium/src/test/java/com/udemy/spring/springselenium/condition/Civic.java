package com.udemy.spring.springselenium.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnExpression("${car.speed} < 70")
public class Civic implements Car {

	@Override
	public void run() {
		System.out.println("Iam Civic. Speed is 60mph");
		
	}

}
