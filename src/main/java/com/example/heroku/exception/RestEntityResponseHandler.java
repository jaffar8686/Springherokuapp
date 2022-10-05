package com.example.heroku.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AlreadyExist.class)
    public ResponseEntity<String> validateEmailId(AlreadyExist alreadyExist){
        return new ResponseEntity<>(alreadyExist.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
