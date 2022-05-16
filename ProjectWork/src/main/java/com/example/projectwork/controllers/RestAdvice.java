package com.example.projectwork.controllers;

import com.example.projectwork.ErrorMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestAdvice {
    @ExceptionHandler(value = Exception.class)
    public ErrorMessage handle(Exception ex){
        return new ErrorMessage(ex.getMessage());
    }
}
