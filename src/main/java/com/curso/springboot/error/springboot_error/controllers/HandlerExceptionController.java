package com.curso.springboot.error.springboot_error.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.curso.springboot.error.springboot_error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(ArithmeticException.class)
    ResponseEntity<Error> DivisionByZeroException(Exception e) {
        Error error = new Error();
        error.setMessage("Error: " + e.getMessage());
        error.setError("Division by zero");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setDate(new java.util.Date());
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<Error> handleException(Exception e) {
        Error error = new Error();
        error.setMessage("Error: " + e.getMessage());
        error.setError("Internal server error");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setDate(new java.util.Date());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> numberFormatException(NumberFormatException e) {

        Map<String, String> error = new HashMap<>();
        error.put("message", "Error: " + e.getMessage());
        error.put("error", "Number format exception");
        error.put("status", String.valueOf(HttpStatus.BAD_REQUEST.value()));
        error.put("date", new java.util.Date().toString());
        return error;

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    ResponseEntity<Error> handleNoHandlerFound(NoHandlerFoundException e) {
        Error error = new Error();
        error.setMessage("Error: " + e.getMessage());
        error.setError("Not found");
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setDate(new java.util.Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}
