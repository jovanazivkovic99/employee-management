package com.jovana.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExistsException extends RuntimeException{
    private String message;
    
    public EmployeeAlreadyExistsException (String message) {
        super(message);
    }
}
