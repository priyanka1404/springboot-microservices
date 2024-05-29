package com.project.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
@OpenAPIDefinition(  //Defining General API information (Using Annotations)-for sagger rest api
		info = @Info(
				title = "Spring boot Rest API  documentation",
				description= "Employee Service rest API documentation ",
				version="v1.0",
				contact=@Contact(
						name = "priyanka",
						email="priyankareddynomula111@gmail.com",
						url="https://github.com/priyanka1404 " // we can provide our website information
				),
				license=@License(
						name = "Apache2.0"
						//url="http "
				)
		),
		// external docs
		externalDocs = @ExternalDocumentation(
				description =  "Spring Boot Employee Service Documentation"
				//url= " "
		)
)




@SpringBootApplication
@EnableFeignClients // it will enable component scanning for interfaces that declare they are feign clients
public class EmployeeServiceApplication {

//	@Bean
//	public RestTemplate restTemplate(){
//		return  new RestTemplate();
//	}
//	@Bean
//	public WebClient webClient(){
//		return  WebClient.builder().build(); // to build the instance
//	}

	// this rest template registered in spring IOC container
	// we can inject this method and we can use this methods

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
