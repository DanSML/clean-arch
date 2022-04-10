package com.example.demo.usecases.account.logout;

import com.example.demo.entites.account.Account;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.account.IAccountRepository;
import com.example.demo.usecases.errors.ErrorHandler;

public class LogOut implements BaseUseCase<Account> {
  IAccountRepository<Account> accountRepository;
  ErrorHandler err = new ErrorHandler();

  public LogOut(IAccountRepository<Account> accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Account exec(Object any) throws Exception, Throwable {
    try {
      if (this.accountRepository.getLoggedAccount() == null) 
        throw new LogOutException("Cannot logout without a logged section!");
      
      this.accountRepository.setLoggedAccountNull();
    } catch (LogOutException error) {
      err.setErrorLog(error);
      throw err;
    }
    return null;
  }
}
