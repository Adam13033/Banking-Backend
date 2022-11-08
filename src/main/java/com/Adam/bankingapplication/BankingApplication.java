package com.Adam.bankingapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class BankingApplication {
	public static void main (String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}
}
