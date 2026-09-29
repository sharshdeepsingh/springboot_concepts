package com.sharshdeep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Lecture11SpringbootCrudApplicationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lecture11SpringbootCrudApplicationDemoApplication.class, args);
		System.out.println("Hello World");
	}

}
