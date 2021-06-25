package me.jjo.gymbook.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    // STATUS CODE 400
    @ExceptionHandler( {
            RuntimeException.class
    })
    public ResponseEntity<?> BadRequestException(final RuntimeException exception) {
        return ResponseEntity.badRequest()
                .body(exception.getMessage());
    }
}
