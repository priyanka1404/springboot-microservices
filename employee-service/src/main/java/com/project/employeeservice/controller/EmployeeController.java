package com.project.employeeservice.controller;



import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//@Controller
//@ResponseBody
// instead of these two annotations we can use RestController
@RestController
@RequestMapping("api/employees")  //// base url for all methods in the class
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    //build save department Rest API


    @PostMapping
    // to make method as restapi we are using spring annotation

    /* ResponseEntity  is  generic class,pass the type */
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){

//@Requestbody:it will convert json to java object,internally it uses http msg converters

       EmployeeDto saveemployee= employeeService.saveEmployee(employeeDto);


         /* this saveEmployee   internally save the user object in database and
       returns the savedEmployee  object that we are stored in  department  object */
       return new ResponseEntity<>(saveemployee , HttpStatus.CREATED);
    }

    //build get employee restapi

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId)
    {
       EmployeeDto employeeDto = employeeService.getEmpById(employeeId);

               return  new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }



}
