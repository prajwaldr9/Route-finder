package com.prajwal.routefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RouteFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouteFinderApplication.class, args);
	}

}
