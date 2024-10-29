package com.hotelManagementSystem.hotel.advice;

import com.hotelManagementSystem.hotel.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class Advice {
    @ExceptionHandler(NotFoundException.class)
    public Map<String, Object> NotFoundExceptionHandler(NotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return response;
    }
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Map<String,Object> SQLIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException ex){
        Map<String,Object> response =new HashMap<>();
        response.put("message",ex.getMessage());
        return response;
    }
}
