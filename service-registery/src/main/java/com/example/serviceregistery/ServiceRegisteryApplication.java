package com.example.serviceregistery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // to make our spring boot application a eureka server-based service Registery
public class ServiceRegisteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegisteryApplication.class, args);
	}

}
