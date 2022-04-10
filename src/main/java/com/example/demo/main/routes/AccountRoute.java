package com.example.demo.main.routes;

import com.example.demo.adapters.controllers.account.ChangeEmailController;
import com.example.demo.adapters.controllers.account.ChangePasswordController;
import com.example.demo.adapters.controllers.account.CreateAccountController;
import com.example.demo.adapters.controllers.account.LogInController;
import com.example.demo.adapters.controllers.account.LogOutController;
import com.example.demo.main.factories.AccountFactory;
import com.example.demo.usecases.dto.account.AccountDTO;
import com.example.demo.usecases.dto.account.ChangeEmailDTO;
import com.example.demo.usecases.dto.account.ChangePasswordDTO;
import com.example.demo.usecases.dto.account.LogInDTO;
import com.example.demo.usecases.errors.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountRoute {
  AccountFactory accountFactory = new AccountFactory();
  CreateAccountController createAccountController = accountFactory.createAccountControllerFactory();
  LogInController logInController = accountFactory.logInControllerFactory();
  ChangeEmailController changeEmailController = accountFactory.changeAccountEmailControllerFactory();
  ChangePasswordController changePasswordController = accountFactory.changePasswordControllerFactory();
  LogOutController logOutController = accountFactory.logOutControllerFactory();

  @PostMapping("/create-account")
  public ResponseEntity<?> createAccount(@RequestBody AccountDTO newAccount) throws Exception, Throwable {
    try {
      Object response = createAccountController.handle(newAccount);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (ErrorHandler err) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrorLog());
    }
  }

  @PostMapping("/log-in")
  public ResponseEntity<?> logIn(@RequestBody LogInDTO logInDTO) throws Exception, Throwable {
    try {
      Object response = logInController.handle(logInDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (ErrorHandler err) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrorLog());
    }
  }

  @PutMapping("/change-email")
  public ResponseEntity<?> changeEmail(@RequestBody ChangeEmailDTO changeEmailDTO) throws Exception, Throwable {
    try {
      Object response = changeEmailController.handle(changeEmailDTO);
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (ErrorHandler err) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrorLog());
    }
  }

  @PutMapping("/change-password")
  public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) throws Exception, Throwable {
    try {
      Object response = changePasswordController.handle(changePasswordDTO);
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (ErrorHandler err) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrorLog());
    }
  }

  @PostMapping("/log-out")
  public ResponseEntity<?> logOut() throws Exception, Throwable {
    try {
      Object response = logOutController.handle(null);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (ErrorHandler err) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrorLog());
    }
  }
}