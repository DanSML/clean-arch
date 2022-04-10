package com.example.demo.usecases.account.login;

import com.example.demo.entites.account.Account;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.account.IAccountRepository;
import com.example.demo.usecases.dto.account.LogInDTO;
import com.example.demo.usecases.errors.ErrorHandler;

public class LogIn implements BaseUseCase<LogInDTO> {
  IAccountRepository<Account> accountRepository;
  ErrorHandler err = new ErrorHandler();

  public LogIn(IAccountRepository<Account> accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public LogInDTO exec(Object logInDTO) throws Exception, Throwable {
    LogInDTO loginData = (LogInDTO) logInDTO;
    try {
      Account data = accountRepository.findByEmail(loginData.getEmail());

      if (data == null) 
        throw new LogInException("Account email does not exists");
      
      if (!data.password.equals(loginData.getPassword()))
        throw new LogInException("Incorrect password");
      
      if (this.accountRepository.getLoggedAccount() != null) 
        throw new LogInException("There is a current section logged");

      this.accountRepository.initiateAccountSection(data);

    } catch (LogInException error) {
      err.setErrorLog(error);
      throw err;
    }
    return loginData;
  }
}
