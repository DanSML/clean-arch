package com.example.demo.usecases.account.create_account;

public class EmailAlreadyExistsException extends Exception {
  public EmailAlreadyExistsException () {
    super("email already exists on dataBase!");
  }
}
