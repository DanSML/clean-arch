package com.example.demo.usecases.errors;

import java.time.Instant;
import org.springframework.http.HttpStatus;

public class ErrorHandler extends Throwable {
  StandardError error = new StandardError();

  public void setErrorLog(Exception err) {
    error.setTimestamp(Instant.now());
    error.setStatus(HttpStatus.BAD_REQUEST.value());
    error.setMessage(err.getMessage());
  }

  public StandardError getErrorLog() {
    return this.error;
  }
}
