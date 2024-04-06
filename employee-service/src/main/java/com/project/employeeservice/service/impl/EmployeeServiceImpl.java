package com.project.employeeservice.service.impl;


import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.entity.Employee;
import com.project.employeeservice.repository.EmployeeRepository;
import com.project.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        // convert dto entity to jpa entity
        Employee employee = new Employee(employeeDto.getId(),
                                      employeeDto.getFirstName(),
                                      employeeDto.getLastName(),
                                      employeeDto.getEmail());


        //save employee in db

        Employee saveEmployee = employeeRepository.save(employee);

        //  convert jpa entity into userDto
        // 1) restapi will expect saved user in response it contains primary key

        EmployeeDto saveemployeeDto= new EmployeeDto(saveEmployee.getId(),
                                                     saveEmployee.getFirstName(),
                                                     saveEmployee.getLastName(),
                                                     saveEmployee.getEmail());

        return saveemployeeDto;
    }

    @Override
    public EmployeeDto getEmpById(Long employeeId) {
        Employee employee= employeeRepository.findById(employeeId).get();
        // convert convert obtained jpa entity into dto
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(),
                                                  employee.getFirstName(),
                                                  employee.getLastName(),
                                                  employee.getEmail());

        return employeeDto;
    }
}
