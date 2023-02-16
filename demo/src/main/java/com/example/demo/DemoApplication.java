package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	//the parameter here (environment) will try to capture the system properties
	ApplicationRunner applicationRunner(Environment environment) {
		return args -> {
			System.out.println("custom message: " + 
		environment.getProperty("custom.message"));
		};
	}
}
