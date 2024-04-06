package com.project.departmentservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.departmentservice.dto.DepartmentDto;
import com.project.departmentservice.entity.Department;
import com.project.departmentservice.repository.DepartmentRepository;
import com.project.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

import java.util.Optional;


@Service  //define @service annotation  for service class
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    
     /* inject UserRepository 
    * after spring 4.3 
    * we cannot use @autowired 
    * because if a spring bean(class) it has single paramaterized constructor we can omit autowired annotation
    */
   private DepartmentRepository departmentRepository;
   private ModelMapper modelMapper;

     


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) { 
       
       

        //convert DEPARTMENT DTO to JPA entity object

        // 1) static method for conversion

        /* Department department = new Department(departmentDto.getId(),
                                         departmentDto.getDepartmentName(),
                                         departmentDto.getDepartmentDescription(),
                                         departmentDto.getDepartmentCode());

    
        // we need to save dept jpa entity  object into db by using save method

         Department savedDepartment =departmentRepository.save(department);


         // convert jpa entity into deptDto
            // 1) restapi will expect saved user in response it contains primary key
    
         DepartmentDto savedDepartmentDto = new DepartmentDto(savedDepartment.getId(),
                                                                            savedDepartment.getDepartmentName(),
                                                                            savedDepartment.getDepartmentDescription(),
                                                                            savedDepartment.getDepartmentCode());

        return savedDepartmentDto;

    */



// 2) model mapper library
        Department department = modelMapper.map(departmentDto,Department.class);

        Department savedDepartment =departmentRepository.save(department);

        DepartmentDto  savedDepartmentDto = modelMapper.map(savedDepartment,DepartmentDto.class);

        return savedDepartmentDto;
    }

    @Override
    // it returns department by deptcode
    public DepartmentDto getDepartmentByCode(String departmentCode) {


        // 1) static method for conversion
        //spring data jpa query method to retrieve department by dept code->(department repository)
      /*  Department department = departmentRepository.findByDepartmentCode(departmentCode);

        // convert dept jpa entity to  dept dto

        DepartmentDto departmentDto = new DepartmentDto(department.getId(),
                                                        department.getDepartmentName(),
                                                    department.getDepartmentDescription(),
                                                     department.getDepartmentCode());

        return departmentDto;

*/


        //2)model mapper library


         Department department = departmentRepository.findByDepartmentCode(departmentCode);

         DepartmentDto departmentDto=modelMapper.map(department,DepartmentDto.class);


         return departmentDto;





    }


}
