package com.example.demo.usecases.account.create_account;

public class EmailValidatorException extends Exception {
  public EmailValidatorException () {
    super("invalid email!");
  }
}
