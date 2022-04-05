package com.example.demo.usecases.account.create_account;


public class PasswordConfirmationException extends Exception {
  public PasswordConfirmationException () {
    super("password and passwordConfirmation should matches!");
  }
}
