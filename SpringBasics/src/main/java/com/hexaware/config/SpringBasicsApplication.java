package com.hexaware.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBasicsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBasicsApplication.class, args);
		UserActivity bean1=context.getBean(UserActivity.class);
		bean1.testA();
	}

}
