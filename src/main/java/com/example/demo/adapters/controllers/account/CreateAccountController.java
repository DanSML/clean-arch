package com.example.demo.adapters.controllers.account;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.usecases.BaseUseCase;

public class CreateAccountController extends BaseController {
  BaseUseCase createAccount;

  public CreateAccountController(BaseUseCase createAccountUse) {
    super(createAccountUse);
    this.createAccount = createAccountUse;
  }

  public Object handle(Object request) throws Exception, Throwable {
    Object result = createAccount.exec(request);
    return result;
  }
}