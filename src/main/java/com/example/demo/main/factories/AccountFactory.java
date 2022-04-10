package com.example.demo.main.factories;

import com.example.demo.adapters.controllers.account.ChangeEmailController;
import com.example.demo.adapters.controllers.account.ChangePasswordController;
import com.example.demo.adapters.controllers.account.CreateAccountController;
import com.example.demo.adapters.controllers.account.LogInController;
import com.example.demo.adapters.controllers.account.LogOutController;
import com.example.demo.infra.repositories_in_memory.account.AccountRepositoryInMemory;
import com.example.demo.usecases.account.change_email.ChangeEmail;
import com.example.demo.usecases.account.change_password.ChangePassword;
import com.example.demo.usecases.account.create_account.CreateAccount;
import com.example.demo.usecases.account.login.LogIn;
import com.example.demo.usecases.account.logout.LogOut;

public class AccountFactory {
  AccountRepositoryInMemory accountRepository = AccountRepositoryInMemory.getAccountInstance();

  public CreateAccountController createAccountControllerFactory() {
    CreateAccount createAccountUse = new CreateAccount(accountRepository);
    CreateAccountController createAccountController = new CreateAccountController(createAccountUse);

    return createAccountController;
  }
  
  public LogInController logInControllerFactory() {
    LogIn logInUseCase = new LogIn(accountRepository);
    LogInController logInController = new LogInController(logInUseCase);

    return logInController;
  }

  public ChangeEmailController changeAccountEmailControllerFactory() {
    ChangeEmail changeEmail = new ChangeEmail(accountRepository);
    ChangeEmailController changeAccountEmailController = new ChangeEmailController(changeEmail);

    return changeAccountEmailController;
  }

  public ChangePasswordController changePasswordControllerFactory() {
    ChangePassword changePassword = new ChangePassword(accountRepository);
    ChangePasswordController changePasswordController = new ChangePasswordController(changePassword);

    return changePasswordController;
  }

  public LogOutController logOutControllerFactory() {
    LogOut logOut = new LogOut(accountRepository);
    LogOutController logOutController = new LogOutController(logOut);

    return logOutController;
  }
}
