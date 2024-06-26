package com.project.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(  //Defining General API information (Using Annotations)-for sagger rest api
		info = @Info(
				title = "Spring boot Rest API  documentation",
				description= "Department Service rest API documentation ",
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
				description =  "Spring Boot Department Documentation"
				//url= " "
		)
)
@SpringBootApplication

public class DepartmentServiceApplication {


	// we need to configure spring bean of model mapper
	@Bean  // it will register in application context
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}


	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
