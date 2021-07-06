package com.typercent.imbac.ToDoApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorExceptionHandling {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorExceptionResponse> handleBaseException(Exception e) {
        ErrorExceptionResponse response = ErrorExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .errorCode("ERR000")
                .error(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorExceptionResponse> handleDataNotFoundException(DataNotFoundException e) {
        ErrorExceptionResponse response = ErrorExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .errorCode(e.getErrorCode())
                .error(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
