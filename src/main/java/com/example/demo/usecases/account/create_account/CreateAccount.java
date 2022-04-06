package com.example.demo.usecases.account.create_account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.entites.account.Account;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.account.IAccountRepository;
import com.example.demo.usecases.dto.account.AccountDTO;
import com.example.demo.usecases.errors.ErrorHandler;

public class CreateAccount implements BaseUseCase {
  IAccountRepository<Account> accountRepository;
  ErrorHandler err = new ErrorHandler();

  public CreateAccount(IAccountRepository<Account> accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Object exec(Object newAccount) throws ErrorHandler {
    AccountDTO accountDTO = (AccountDTO) newAccount;
    try {
      Pattern pattern  = Pattern.compile("^(.+)@(.+)$");
      Matcher matcher = pattern.matcher(accountDTO.email);

      if (!matcher.matches()) 
        throw new CreateAccountException("invalid email format!");

      if (this.accountRepository.findByEmail(accountDTO.email) != null) 
        throw new CreateAccountException("email already exists on dataBase!");

      if (!accountDTO.password.equals(accountDTO.passwordConfirmation))
        throw new CreateAccountException("password and passwordConfirmation should matches!");
    } 
    catch (CreateAccountException error) {
      err.setErrorLog(error);
      throw err;
    }

    Account account = new Account(
      accountDTO.name, 
      accountDTO.email,
      accountDTO.role, 
      accountDTO.password
    );

    this.accountRepository.save(account);
    return account;
  }
}
