package com.example.demo.adapters.controllers.account;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.entites.account.Account;
import com.example.demo.usecases.BaseUseCase;

public class CreateAccountController extends BaseController<Account> {
  BaseUseCase<Account> createAccount;

  public CreateAccountController(BaseUseCase<Account> createAccount) {
    super(createAccount);
    this.createAccount = createAccount;
  }

  @Override
  public Object handle(Object request) throws Exception, Throwable {
    Object result = createAccount.exec(request);
    return result;
  }
}