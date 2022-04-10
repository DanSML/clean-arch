package com.example.demo.adapters.controllers.account;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.entites.account.Account;
import com.example.demo.usecases.BaseUseCase;

public class LogOutController extends BaseController<Account> {
  BaseUseCase<Account> logOut;

  public LogOutController(BaseUseCase<Account> logOut) {
    super(logOut);
    this.logOut = logOut;
  }

  @Override
  public Object handle(Object request) throws Exception, Throwable {
    logOut.exec(request);
    return null;
  }
}
