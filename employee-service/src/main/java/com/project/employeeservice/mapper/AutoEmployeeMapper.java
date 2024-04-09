package com.project.employeeservice.mapper;

import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper

{
    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);
    // we need to create  mapstruct methods
    //we can use this Mapper instance to call this mapping methods

    Employee mapToEmployee(EmployeeDto  employeeDto);
    EmployeeDto mapToEmployeeDto(Employee employee);

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
