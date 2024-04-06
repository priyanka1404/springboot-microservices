package com.project.departmentservice.service;

import com.project.departmentservice.dto.DepartmentDto;

public interface DepartmentService {


    //create a   method, return type is DepartmentDto
    DepartmentDto saveDepartment(DepartmentDto  departmentDto); // pass the dto entity as argument
    DepartmentDto getDepartmentByCode(String code);

}
