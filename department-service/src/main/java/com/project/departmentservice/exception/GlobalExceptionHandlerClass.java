package com.project.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
// to handle exception globally
/* here we will handle  specific exception and global exception in single place  */
public class GlobalExceptionHandlerClass {

   // to handl specific  exception in  global exception

    @ExceptionHandler(ResourceNotFoundException.class)// we need to pass the exception we are going to handle specific exception
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {

        /*we need to pass two arguments to this method
         * 1)type of exception
         *2) web request( WE NEED SOME DETAILS FROM WEB REQUEST )
         */

        /* we need to create the instance of error details */

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false), "User _not_found");

//if we pass true ,it will fetch client info

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }
// run time exception->exception->throwable->object
// exception is a super class for both checked and unchecked exception

// here  the logic is to handle all the  exceptions other than specific exceptions handled above

// global exception handler

        @ExceptionHandler(Exception.class)// we need to pass the exception we are going to handle specific exception
        public ResponseEntity<ErrorDetails> handleException(Exception exception, WebRequest webRequest){

            /*we need to pass two arguments to this method
             * 1)type of exception
             *2) web request( WE NEED SOME DETAILS FROM WEB REQUEST )
             */

            /* we need to create the instance of error details */

            ErrorDetails errorDetails = new ErrorDetails(
                    LocalDateTime.now(),
                    exception.getMessage(),
                    webRequest.getDescription(false),"Internal_Server_Error");

//if we pass true ,it will fetch client info

            return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
        }






}
