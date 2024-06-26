package com.project.departmentservice.controller;

import com.project.departmentservice.exception.ErrorDetails;
import com.project.departmentservice.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import com.project.departmentservice.dto.DepartmentDto;
import com.project.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


//@Controller
//@ResponseBody
// instead of these two annotations we can use RestController


// swagger rest api annotation
@Tag(  //Customizing Swagger API Documentation with Annotation
        name = "Department Service - DepartmentController",
        description =" DepartmentController  exposes Rest API's for Department service"
)


@RestController
@RequestMapping("api/departments") // base url for all methods in the class
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    //build save department Rest API


    // to provide summary for documentation
    @Operation(
       summary = "Save Department Rest API",
            description ="Save Department Rest API is used to save department object in a database"
    )
    // to provide response in documentation
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    @PostMapping
    // to make method as restapi we are using spring annotation

    /* ResponseEntity  is  generic class,pass the type */

    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        //@Requestbody:it will convert json to java object,internally it uses http msg converters .
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);

         /* this saveDepartment  internally save the user object in database and 
       returns the savedDepartment  object that we are stored in  department  object */

        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // to provide summary for documentation
    @Operation(
            summary = "Get Department Rest API",
            description ="Get Department Rest API is used to get  department object in a database"
    )
    // to provide response in documentation
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 SUCCESS"
    )

    //build get  department Rest API
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDeptCode(@PathVariable("department-code") String departmentCode) {
        // @PathVariable to bind the url template  with method argument
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);

    }


//    // to handle specific exception in controller
//@ExceptionHandler(ResourceNotFoundException.class) // we need to pass the exception we are going to handle
//    public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest)
//{
///*we need to pass two arguments to this method
// * 1)type of exception
// *2) web request( WE NEED SOME DETAILS FROM WEB REQUEST )
// */
//
///* we need to create the instance of error details */
//
//    ErrorDetails errorDetails = new ErrorDetails(
//            LocalDateTime.now(),
//            exception.getMessage(),
//            webRequest.getDescription(false),"User _not_found");
//
//    //if we pass true ,it will fetch client info
//
//    return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }
//

}

    





