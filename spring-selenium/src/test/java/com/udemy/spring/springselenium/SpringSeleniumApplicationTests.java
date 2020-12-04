package com.udemy.spring.springselenium;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;
import com.udemy.spring.springselenium.config.ListData;

@SpringBootTest
class SpringSeleniumApplicationTests {

	@Autowired
	private User user;

	@Value("${Path}")
	private String path;

	@Value("${TEST_URL:https://www.google.com}")
	private String test_url;

	@Value("${fruits}")
	private List<String> fruits;

	@Autowired
	private Faker faker;

	@Autowired
	private Television tv;

	@Autowired
	private ListData listData;

	@Test
	void contextLoads() {

		user.printDetails();

		System.out.println(path);

		System.out.println(test_url);

		System.out.println(fruits);

		// Faker faker = new Faker();
		System.out.println(faker.name().firstName());

		/**
		 * Address address = new Address(); Salary salary = new Salary(); User user =
		 * new User(address, salary); user.printDetails();
		 **/

		tv.playMovie();

		System.out.println(listData.list());

	}

}
