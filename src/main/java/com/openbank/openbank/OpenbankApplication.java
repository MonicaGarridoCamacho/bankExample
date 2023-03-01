package com.openbank.openbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.openbank.controller"})
public class OpenbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenbankApplication.class, args);
	}

}
