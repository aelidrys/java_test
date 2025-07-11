package com.example.contractapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ContractNotFoundAdvice {

  @ExceptionHandler(ContractNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String contractNotFoundHandler(ContractNotFoundException ex) {
    return ex.getMessage();
  }
}


