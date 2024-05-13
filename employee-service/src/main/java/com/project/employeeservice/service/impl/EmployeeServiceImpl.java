package com.project.employeeservice.service.impl;


import com.project.employeeservice.dto.APIResponseDto;
import com.project.employeeservice.dto.DepartmentDto;
import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.dto.OrganizationDto;
import com.project.employeeservice.entity.Employee;
import com.project.employeeservice.exception.ResourceNotFoundException;
import com.project.employeeservice.mapper.AutoEmployeeMapper;
import com.project.employeeservice.repository.EmployeeRepository;
import com.project.employeeservice.service.APIClient;
import com.project.employeeservice.service.APIOrgClient;
import com.project.employeeservice.service.EmployeeService;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository employeeRepository;

    //inject rest template
    // private RestTemplate restTemplate;

    //private WebClient webClient;
    private APIClient apiClient;
    private APIOrgClient apiOrgClient;


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

    //@CircuitBreaker(name = "${spring.application.name}",fallbackMethod="getDefaultDepartment")
    //retry pattern
    @Retry(name = "${spring.application.name}",fallbackMethod="getDefaultDepartment")
    @Override
    public APIResponseDto getEmpById(Long employeeId) {

        LOGGER.info("inside getEmployeeById() method");
     /*   Employee employee= employeeRepository.findById(employeeId).get();
        //  convert obtained jpa entity into dto
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

      /* rest template code
       ResponseEntity<DepartmentDto>  responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+ employee.getDepartmentCode(), DepartmentDto.class);
        // it will make  a rest api call and it will return  department dto response
        DepartmentDto departmentDto = responseEntity.getBody();

        */


        /* web client code
          DepartmentDto departmentDto =   webClient.get()
                     .uri("http://localhost:8080/api/departments/"+ employee.getDepartmentCode())
                     .retrieve()
                     .bodyToMono(DepartmentDto.class)  // to pass response type
                     .block();  // to make a synchronous  call
         */


        /*  open feign client  */

         DepartmentDto departmentDto= apiClient.getDeptCode(employee.getDepartmentCode());
        OrganizationDto organizationDto= apiOrgClient.getOrganizationCode(employee.getOrganizationCode());

        //Employee employee = optionalEmployeeemployee.get();

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);


        APIResponseDto apiResponseDto = new APIResponseDto();

        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);
        LOGGER.info("inside setOrganization  method");
        return apiResponseDto;

    }


    public APIResponseDto getDefaultDepartment(Long employeeId,Exception exception) {

        LOGGER.info("inside getDefaultDepartment() method");
        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto =new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");




        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);


        APIResponseDto apiResponseDto = new APIResponseDto();

        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;

    }
}
