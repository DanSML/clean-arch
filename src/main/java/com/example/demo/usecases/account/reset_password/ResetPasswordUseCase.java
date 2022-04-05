package com.example.demo.usecases.account.reset_password;

import com.example.demo.infra.repositories_in_memory.account.AccountRepositoryInMemory;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.errors.ErrorHandler;

public class ResetPasswordUseCase implements BaseUseCase {
  AccountRepositoryInMemory accountRepository;
  ErrorHandler err = new ErrorHandler();

  public ResetPasswordUseCase(AccountRepositoryInMemory accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Object exec(Object any) throws Exception, Throwable {
    return null;
  }
}
