package com.project.employeeservice.controller;



import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.exception.ErrorDetails;
import com.project.employeeservice.exception.ResourceNotFoundException;
import com.project.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


//@Controller
//@ResponseBody
// instead of these two annotations we can use RestController
@RestController
@RequestMapping("api/employees")  //// base url for all methods in the class

//http://localhost:8081/api/employees
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




    // to handle specific exception in controller
//@ExceptionHandler(ResourceNotFoundException.class) // we need to pass the exception we are going to handle
 //  public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest)
//{
/*we need to pass two arguments to this method
 * 1)type of exception
  *2) web request( WE NEED SOME DETAILS FROM WEB REQUEST )
 */

/* we need to create the instance of error details */

 //ErrorDetails errorDetails = new ErrorDetails(
  //        LocalDateTime.now(),
   //        exception.getMessage(),
   //        webRequest.getDescription(false),"User _not_found");

   //if we pass true ,it will fetch client info

  // return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
  //  }


}
