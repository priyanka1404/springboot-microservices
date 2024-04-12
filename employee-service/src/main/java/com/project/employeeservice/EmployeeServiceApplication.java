package com.project.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmployeeServiceApplication {

//	@Bean
//	public RestTemplate restTemplate(){
//		return  new RestTemplate();
//	}
	@Bean
	public WebClient webClient(){
		return  WebClient.builder().build(); // to build the instance
	}
	// this rest template registered in spring IOC container
	// we can inject this method and we can use this methods

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
