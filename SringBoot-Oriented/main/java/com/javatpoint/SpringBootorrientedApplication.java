package com.javatpoint;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@SpringBootApplication
public class SpringBootorrientedApplication{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootorrientedApplication.class, args);
	
	}
}