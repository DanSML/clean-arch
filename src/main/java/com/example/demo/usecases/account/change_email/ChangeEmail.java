package com.example.demo.usecases.account.change_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.entites.account.Account;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.account.IAccountRepository;
import com.example.demo.usecases.dto.account.ChangeEmailDTO;
import com.example.demo.usecases.errors.ErrorHandler;

public class ChangeEmail implements BaseUseCase<ChangeEmailDTO> {
  IAccountRepository<Account> accountRepository;
  ErrorHandler err = new ErrorHandler();

  public ChangeEmail (IAccountRepository<Account> accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Object exec(Object changeEmailData) throws Exception, Throwable {
    ChangeEmailDTO changeEmailDTO = (ChangeEmailDTO) changeEmailData;
    Account loggedAccount = this.accountRepository.getLoggedAccount();

    try {
      Pattern pattern  = Pattern.compile("^(.+)@(.+)$");
      Matcher matcher = pattern.matcher(changeEmailDTO.getEmail());

      if (loggedAccount == null)
        throw new ChangeEmailException("Cannot change email without a logged section!");

      if (!changeEmailDTO.getEmail().equals(changeEmailDTO.getEmailConfirmation()))
        throw new ChangeEmailException("The email and emailConfirmation fields does not matches!");

      if (!matcher.matches()) 
        throw new ChangeEmailException("invalid email format!");

      if (this.accountRepository.findByEmail(changeEmailDTO.getEmail()) != null) 
        throw new ChangeEmailException("Email already exists on Database");

      loggedAccount.setEmail(changeEmailDTO.getEmail());

    } catch (ChangeEmailException error) {
      err.setErrorLog(error);
      throw err;
    }
    return loggedAccount;
  }
}
