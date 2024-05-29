package com.project.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(  //Defining General API information (Using Annotations)-for sagger rest api
		info = @Info(
				title = "Spring boot Rest API  documentation",
				description= "Organization Service rest API documentation ",
				version="v1.0",
				contact=@Contact(
						name = "Priyanka Reddy ",
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
				description =  "Spring Boot Organization service Documentation"
				//url= " "
		)
)

@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
