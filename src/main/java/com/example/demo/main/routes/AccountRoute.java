package com.example.demo.main.routes;

import com.example.demo.adapters.controllers.account.CreateAccountController;
import com.example.demo.main.factories.AccountFactory;
import com.example.demo.usecases.dto.account.AccountDTO;
import com.example.demo.usecases.errors.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountRoute {
  AccountFactory accountFactory = new AccountFactory();
  CreateAccountController createAccountController = accountFactory.createAccountControllerFactory();

  @PostMapping("/create-account")
  public ResponseEntity<?> createAccount(@RequestBody AccountDTO newAccount) throws Exception, Throwable {
    try {
      Object response = createAccountController.handle(newAccount);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (ErrorHandler err) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrorLog());
    }
  }

}