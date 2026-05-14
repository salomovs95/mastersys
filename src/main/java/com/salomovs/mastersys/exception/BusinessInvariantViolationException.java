package com.salomovs.mastersys.exception;

public class BusinessInvariantViolationException extends RuntimeException {
  public BusinessInvariantViolationException(String message) {
    super(message);
  }
}
