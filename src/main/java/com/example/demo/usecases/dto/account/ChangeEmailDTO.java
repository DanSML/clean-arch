package com.example.demo.usecases.dto.account;

public class ChangeEmailDTO {
  private String email;
  private String emailConfirmation;

  public ChangeEmailDTO(
    String email,
    String emailConfirmation
  ) {
    this.email = email;
    this.emailConfirmation = emailConfirmation;
  }

  public String getEmail() {
    return this.email;
  }

  public String getEmailConfirmation() {
    return this.emailConfirmation;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setEmailConfirmation(String emailConfirmation) {
    this.emailConfirmation = emailConfirmation;
  }
}
