package com.learning.example.practice.springpracticesession3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Springpracticesession3Application {

	public static void main(String[] args) {
		SpringApplication.run(Springpracticesession3Application.class, args);
	}

}
