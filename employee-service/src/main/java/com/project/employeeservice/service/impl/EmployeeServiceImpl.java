package com.project.employeeservice.service.impl;


import com.project.employeeservice.dto.APIResponseDto;
import com.project.employeeservice.dto.DepartmentDto;
import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.entity.Employee;
import com.project.employeeservice.exception.ResourceNotFoundException;
import com.project.employeeservice.mapper.AutoEmployeeMapper;
import com.project.employeeservice.repository.EmployeeRepository;
import com.project.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //inject rest template
     private RestTemplate restTemplate;
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
    public APIResponseDto getEmpById(Long employeeId) {


     /*   Employee employee= employeeRepository.findById(employeeId).get();
        // convert convert obtained jpa entity into dto
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(),
                                                  employee.getFirstName(),
                                                  employee.getLastName(),
                                                  employee.getEmail());

        return employeeDto;

      */

        //2)map struct library


//        //2)map struct library
//        Optional<Employee> optionalEmployeeemployee= employeeRepository.findById(employeeId);
//        Employee employee = optionalEmployeeemployee.get();
//
//        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
//
//    }

        // to handle  specific exception
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(
               ()->new ResourceNotFoundException("Employee","id",employeeId)
        );


       ResponseEntity<DepartmentDto>  responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+ employee.getDepartmentCode(), DepartmentDto.class);
        // it will make  a rest api call and it will return  department dto response
        DepartmentDto departmentDto = responseEntity.getBody();





        //Employee employee = optionalEmployeeemployee.get();

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);


        APIResponseDto apiResponseDto = new APIResponseDto();

        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;

    }
}
