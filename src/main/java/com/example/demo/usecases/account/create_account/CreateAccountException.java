package com.example.demo.usecases.account.create_account;

public class CreateAccountException extends Exception {
  public CreateAccountException (String errorMsg) {
    super(errorMsg);
  }
}
