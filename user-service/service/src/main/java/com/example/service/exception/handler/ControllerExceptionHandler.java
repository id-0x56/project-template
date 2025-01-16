package com.example.service.exception.handler;

import com.example.common.exception.ResponseException;
import com.example.service.exception.AlreadyExistException;
import com.example.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handle(NotFoundException exception) {
        return response(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<?> handle(AlreadyExistException exception) {
        return response(HttpStatus.BAD_REQUEST, exception);
    }

    private ResponseEntity<?> response(HttpStatus httpStatus, Exception exception) {
        ResponseException responseException = ResponseException.builder()
                .code(httpStatus.value())
                .messages(List.of(exception.getMessage()))
                .date(Instant.now())
                .build();

        return ResponseEntity.status(httpStatus)
                .body(responseException);
    }
}
