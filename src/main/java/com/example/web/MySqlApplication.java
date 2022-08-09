package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.example")
public class MySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlApplication.class, args);
	}

}
