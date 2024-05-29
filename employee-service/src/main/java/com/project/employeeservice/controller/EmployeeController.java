package com.project.employeeservice.controller;



import com.project.employeeservice.dto.APIResponseDto;
import com.project.employeeservice.dto.EmployeeDto;
import com.project.employeeservice.exception.ErrorDetails;
import com.project.employeeservice.exception.ResourceNotFoundException;
import com.project.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


//@Controller
//@ResponseBody
// instead of these two annotations we can use RestController

// swagger rest api annotation
@Tag(  //Customizing Swagger API Documentation with Annotation
        name = "Employee Service - EmployeeController",
        description =" EmployeeController  exposes Rest API's for Employee service"
)
@RestController
@RequestMapping("api/employees")  //// base url for all methods in the class

//http://localhost:8081/api/employees
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    //build save department Rest API

    @Operation(
            summary = "Save Employee Rest API",
            description ="Save Employee Rest API is used to save Employee object in a database"
    )
    // to provide response in documentation
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )

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



    @Operation(
            summary = "Get Employee Rest API",
            description ="Get Employee Rest API is used to Get Employee object in a database"
    )
    // to provide response in documentation
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 ok"
    )
    //build get employee restapi

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId)
    {
      // EmployeeDto employeeDto = employeeService.getEmpById(employeeId);
        APIResponseDto apiResponseDto  = employeeService.getEmpById(employeeId);

               return  new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
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
