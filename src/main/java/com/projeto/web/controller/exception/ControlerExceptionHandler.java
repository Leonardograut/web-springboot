package com.projeto.web.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projeto.web.service.exception.ControlerNotFoundException;
import com.projeto.web.service.exception.DatabaseException;

@ControllerAdvice
public class ControlerExceptionHandler {
     

    @ExceptionHandler(ControlerNotFoundException.class)
    public ResponseEntity<StandardError>controlerNotFound(ControlerNotFoundException e, HttpServletRequest request){
        String error = "Controller not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
       StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());
       return ResponseEntity.status(status).body(err);
    }



    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError>database(DatabaseException e, HttpServletRequest request){
        String error = "Database erro";
        HttpStatus status = HttpStatus.BAD_REQUEST;
       StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());
       return ResponseEntity.status(status).body(err);
    }


}
