package com.project.employeeservice.service;

import com.project.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url ="http://localhost:8083",value ="organization-service")
//@FeignClient(name="organization-service")
// open feign client library dynamically create implementation for this library
 public interface APIOrgClient {

    //Build Get organization by code using Rest API
    @GetMapping("api/organizations/{code}")
    OrganizationDto getOrganizationCode(@PathVariable("code") String organizationCode);

}
