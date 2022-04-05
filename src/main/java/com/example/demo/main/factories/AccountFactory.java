package com.example.demo.main.factories;

import com.example.demo.adapters.controllers.account.CreateAccountController;
import com.example.demo.adapters.controllers.account.GetAllAccountsController;
import com.example.demo.adapters.controllers.account.LogInController;
import com.example.demo.adapters.controllers.account.ResetPasswordController;
import com.example.demo.infra.repositories_in_memory.account.AccountRepositoryInMemory;
import com.example.demo.usecases.account.create_account.CreateAccountUseCase;
import com.example.demo.usecases.account.get_all_accounts.GetAllAccountsUseCase;
import com.example.demo.usecases.account.login.LogInUseCase;
import com.example.demo.usecases.account.reset_password.ResetPasswordUseCase;

public class AccountFactory {
  AccountRepositoryInMemory accountRepository = AccountRepositoryInMemory.getAccountInstance();

  public CreateAccountController createAccountControllerFactory() {
    CreateAccountUseCase createAccountUse = new CreateAccountUseCase(accountRepository);
    CreateAccountController createAccountController = new CreateAccountController(createAccountUse);

    return createAccountController;
  }

  public ResetPasswordController resetPasswordControllerFactory() {
    ResetPasswordUseCase resetPasswordUseCase = new ResetPasswordUseCase(accountRepository);
    ResetPasswordController resetPasswordController = new ResetPasswordController(resetPasswordUseCase);
  
    return resetPasswordController;
  }

  public LogInController logIControllerFactory() {
    LogInUseCase logInUseCase = new LogInUseCase(accountRepository);
    LogInController logInController = new LogInController(logInUseCase);

    return logInController;
  }

  public GetAllAccountsController getAllAccountsControllerFactory() {
    GetAllAccountsUseCase getAllAccountsUseCase = new GetAllAccountsUseCase(accountRepository);
    GetAllAccountsController getAllAccountsController = new GetAllAccountsController(getAllAccountsUseCase);

    return getAllAccountsController;
  }
}
