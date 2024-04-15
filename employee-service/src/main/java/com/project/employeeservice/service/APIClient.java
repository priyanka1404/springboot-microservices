package com.project.employeeservice.service;

import com.project.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url ="http://localhost:8080;http://localhost:8082",value ="DEPARTMENT-SERVICE")
@FeignClient(name="DEPARTMENT-SERVICE")
// open feign client library dynamically create implementation for this library
public interface APIClient {

    // we need to call department rest api method without implementation

    //build get  department Rest API
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDeptCode(@PathVariable("department-code") String departmentCode);


}
