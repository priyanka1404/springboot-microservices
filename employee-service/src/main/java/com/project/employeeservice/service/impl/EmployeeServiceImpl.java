package com.project.employeeservice.service.impl;


import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.entity.Employee;
import com.project.employeeservice.mapper.AutoEmployeeMapper;
import com.project.employeeservice.repository.EmployeeRepository;
import com.project.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//1) static methods
        // convert dto entity to jpa entity
      /*  Employee employee = new Employee(employeeDto.getId(),
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

       */

        //2)mapstruct library

        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee =employeeRepository.save(employee);
        EmployeeDto savedemployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);

        return savedemployeeDto;

    }

    @Override
    public EmployeeDto getEmpById(Long employeeId) {


     /*   Employee employee= employeeRepository.findById(employeeId).get();
        // convert convert obtained jpa entity into dto
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(),
                                                  employee.getFirstName(),
                                                  employee.getLastName(),
                                                  employee.getEmail());

        return employeeDto;

      */

        //2)map struct library
        Optional<Employee> optionalEmployeeemployee= employeeRepository.findById(employeeId);
        Employee employee = optionalEmployeeemployee.get();

        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);

    }
}
