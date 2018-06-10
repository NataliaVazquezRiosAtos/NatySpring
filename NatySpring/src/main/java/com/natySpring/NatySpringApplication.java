package com.natySpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NatySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NatySpringApplication.class, args);
	}
}


