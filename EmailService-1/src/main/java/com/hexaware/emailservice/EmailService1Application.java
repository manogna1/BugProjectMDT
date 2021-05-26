package com.hexaware.emailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmailService1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmailService1Application.class, args);
	}

}
