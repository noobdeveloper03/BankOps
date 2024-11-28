package com.demo.BankOps.handler;

import com.demo.BankOps.dto.BankResponse;
import com.demo.BankOps.exception.BankException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(BankException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<BankResponse> handlerError(BankException bankException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BankResponse(bankException.getMessage()));
    }
}
