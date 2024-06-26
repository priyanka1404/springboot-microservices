package com.project.organizationservice.mapper;

import com.project.organizationservice.dto.OrganizationDto;
import com.project.organizationservice.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoOrganizationMapper {
    // we need to create  mapstruct methods
    AutoOrganizationMapper MAPPER = Mappers.getMapper(AutoOrganizationMapper.class);

    //we can use this Mapper instance to call this mapping methods

    OrganizationDto mapToOrganizationDto(Organization organization);  //dto -> jpa
    Organization mapToOrganization(OrganizationDto organizationDto);  //jpa->dto

    // map struct will provide implementation during compilation time
    // no need to write code to implement these methods


    // inorder to map one object to another objects both fields should have same field name
    //if both are not same we can use map struct(@mapping) annotation
    /*example
     * @Mapping(source="email",target="emailAddress")
     * src=jpa
     * target=dto
     */


   /* we cannot create object  for interface,here in mapstruct no need to provide implementation
   inorder  to  provide implementation for this interface  we  need to use mapper utility class */


}
