package com.project.employeeservice.service;


import com.project.employeeservice.dto.APIResponseDto;
import com.project.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

   // EmployeeDto getEmpById(Long employeeId);
   APIResponseDto getEmpById(Long employeeId);
}
