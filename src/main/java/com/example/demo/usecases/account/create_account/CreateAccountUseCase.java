package com.example.demo.usecases.account.create_account;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.entites.account.Account;
import com.example.demo.infra.repositories_in_memory.account.AccountRepositoryInMemory;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.errors.ErrorHandler;

public class CreateAccountUseCase implements BaseUseCase {
  AccountRepositoryInMemory accountRepository;
  ErrorHandler err = new ErrorHandler();

  public CreateAccountUseCase(AccountRepositoryInMemory accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Object exec(Object newAccount) throws ErrorHandler {
    AccountModel test = (AccountModel) newAccount;
    try {
      Pattern pattern  = Pattern.compile("^(.+)@(.+)$");
      Matcher matcher = pattern.matcher(test.email);
      if (!matcher.matches()) throw new EmailValidatorException();
      if (this.accountRepository.findByEmail(test.email) != null) {
        throw new EmailAlreadyExistsException();
      }
      if (!test.password.equals(test.passwordConfirmation)) {
        throw new PasswordConfirmationException();
      }
    } 
    catch (EmailValidatorException error) {
      err.setErrorLog(error);
      throw err;
    }
    catch (EmailAlreadyExistsException error) {
      err.setErrorLog(error);
      throw err;
    }
    catch (PasswordConfirmationException error) {
      err.setErrorLog(error);
      throw err;
    }

    Account account = new Account(
      test.name, 
      test.email,
      test.role, 
      test.password
    );
    UUID uuid = UUID.randomUUID();
    account.setUuid(uuid.toString());
    this.accountRepository.save(account);
    return account;
  }
}
