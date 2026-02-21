package com.urbanride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.urbanride")
public class UrbanRideApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrbanRideApplication.class, args);
		System.out.println("Starting Urban Ride Application");
	}

}
