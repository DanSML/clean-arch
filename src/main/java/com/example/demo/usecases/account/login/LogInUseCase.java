package com.example.demo.usecases.account.login;

import com.example.demo.infra.repositories_in_memory.account.AccountRepositoryInMemory;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.errors.ErrorHandler;

public class LogInUseCase implements BaseUseCase {
  AccountRepositoryInMemory accountRepository;
  ErrorHandler err = new ErrorHandler();

  public LogInUseCase(AccountRepositoryInMemory accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Object exec(Object any) throws Exception, Throwable {
    return null;
  }
}
