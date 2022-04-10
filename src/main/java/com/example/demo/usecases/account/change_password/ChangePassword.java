package com.example.demo.usecases.account.change_password;

import com.example.demo.entites.account.Account;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.account.IAccountRepository;
import com.example.demo.usecases.dto.account.ChangePasswordDTO;
import com.example.demo.usecases.errors.ErrorHandler;

public class ChangePassword implements BaseUseCase<Object> {
  IAccountRepository<Account> accountRepository;
  ErrorHandler err = new ErrorHandler();

  public ChangePassword (IAccountRepository<Account> accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Object exec(Object any) throws Exception, Throwable {
    ChangePasswordDTO changePasswordDTO = (ChangePasswordDTO) any;
    Account loggedAccount = this.accountRepository.getLoggedAccount();
    try {
      if (loggedAccount == null)
        throw new ChangePasswordException("Cannot change password without a logged section!");

      if (!loggedAccount.password.equals(changePasswordDTO.oldPassword))
        throw new ChangePasswordException("The oldPassword field is incorrect!");

      if (!changePasswordDTO.newPassword.equals(changePasswordDTO.newPasswordConfirmation))
        throw new ChangePasswordException("The newPassword and newPasswordConfirmation fields should matches!");

    } catch (ChangePasswordException error) {
      err.setErrorLog(error);
      throw err;
    }

    loggedAccount.setPassword(changePasswordDTO.newPassword);
    return null;
  }
}
