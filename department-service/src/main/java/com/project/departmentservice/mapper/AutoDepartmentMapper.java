package com.project.departmentservice.mapper;

import com.project.departmentservice.dto.DepartmentDto;
import com.project.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    // we need to create  mapstruct methods
    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    //we can use this Mapper instance to call this mapping methods

    DepartmentDto mapToDepartmentDto(Department department);  //dto -> jpa
    Department mapToDepartment(DepartmentDto departmentDto);  //jpa->dto

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
