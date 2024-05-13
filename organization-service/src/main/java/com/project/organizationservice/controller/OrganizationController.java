package com.project.organizationservice.controller;


import com.project.organizationservice.dto.OrganizationDto;
import com.project.organizationservice.entity.Organization;
import com.project.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor// base url for all methods in the class)
public class OrganizationController {
    private OrganizationService organizationService;


    //build save department Rest API

    @PostMapping
    // to make method as restapi we are using spring annotation

    /* ResponseEntity  is  generic class,pass the type */

    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        //@Requestbody:it will convert json to java object,internally it uses http msg converters .
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);

         /* this saveDepartment  internally save the user object in database and
       returns the savedDepartment  object that we are stored in  department  object */

        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }


    //Build Get organization by code using Rest API
@GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganizationCode(@PathVariable("code") String organizationCode)
    {
        OrganizationDto organizationDto  = organizationService.getOrganizationByCode(organizationCode);

        return ResponseEntity.ok( organizationDto);
    }
}
