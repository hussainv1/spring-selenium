package com.udemy.spring.springselenium;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Television {

	@Value("${tv.name:sony}")
	private String name;

	public Television() {
		System.out.println("Inside the Constructor: " + this.name);
	}

	@PostConstruct
	private void init() {
		System.out.println("Inside the init: " + this.name);
		System.out.println("Turning on the TV..");
	}

	public void playMovie() {
		for (int i = 1; i <= 6; i++) {
			System.out.println("Playing the scene " + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@PreDestroy
	private void turnOff() {
		System.out.println("Turning of TV...");
	}

}
