package com.syscho.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public static final String TIMESTAMP = "timestamp";
    public static final String MESSAGE = "message";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(
            NoDataFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(MESSAGE, "Something went wrong , Try again !!");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNodataFoundException(
            NoDataFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(MESSAGE, ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


}
