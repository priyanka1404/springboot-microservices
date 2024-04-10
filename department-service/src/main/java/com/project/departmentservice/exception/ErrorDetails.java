package com.project.departmentservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;



// error details class to hold of the custom error response
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {


    private LocalDateTime timeStamp;
    private String message;
    private String path;
    private String errorCode;

}
