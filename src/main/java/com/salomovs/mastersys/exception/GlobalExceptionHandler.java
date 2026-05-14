package com.salomovs.mastersys.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.salomovs.mastersys.dto.response.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handkeExcpetuon(MethodArgumentNotValidException exception) {
    List<String> errors = exception.getBindingResult()
      .getFieldErrors()
      .stream()
      .map(e -> e.getField() + ": " + e.getDefaultMessage())
      .toList();

    return new ExceptionResponse(
      HttpStatus.BAD_REQUEST.value(),
      exception.getLocalizedMessage(),
      errors);
  }

  @ExceptionHandler(BusinessInvariantViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleException(BusinessInvariantViolationException e) {
    ExceptionResponse response = new ExceptionResponse(
      HttpStatus.BAD_REQUEST.value(),
      e.getLocalizedMessage(),
      List.of(e.getMessage())
    );
    return response;
  }

}
