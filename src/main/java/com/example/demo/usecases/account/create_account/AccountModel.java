package com.example.demo.usecases.account.create_account;

public class AccountModel {
  public String name;
  public String role;
  public String email;
  public String password;
  public String passwordConfirmation;

  public AccountModel (
    String name,
    String role,
    String email,
    String password,
    String passwordConfirmation 
  ) {
    this.name = name;
    this.role = role;
    this.email = email;
    this.password = password;
    this.passwordConfirmation = passwordConfirmation;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPasswordConfirmation() {
    return passwordConfirmation;
  }

  public void setPasswordConfirmation(String passwordConfirmation) {
    this.passwordConfirmation = passwordConfirmation;
  }
}
