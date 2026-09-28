package com.sharshdeep.lecture_09_springboot_core_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

// @EnableAutoConfiguration: It says look at the spring boot project and create beans for the
public class Lecture09SpringbootCoreDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=
		SpringApplication.run(Lecture09SpringbootCoreDemoApplication.class, args);
		OrderService order=context.getBean(OrderService.class);
		order.placeOrder();


	}
	@Bean
	public  UserService getUserServiceBean()
	{
		return new UserService();
	}
}
