package com.example.demo.usecases.errors;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
  private static final long serialVersionUID = 1L;
  private Instant timestamp;
  private Integer status;
  private String message;

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
