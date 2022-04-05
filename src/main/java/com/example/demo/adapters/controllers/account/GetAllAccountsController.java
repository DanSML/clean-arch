package com.example.demo.adapters.controllers.account;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.usecases.BaseUseCase;

public class GetAllAccountsController extends BaseController {
  BaseUseCase getAllAccounts;

  public GetAllAccountsController(BaseUseCase getAllAccounts) {
    super(getAllAccounts);
    this.getAllAccounts = getAllAccounts;
  }

  @Override
  public Object handle(Object request) throws Exception, Throwable {
    Object result = getAllAccounts.exec(request);
    return result;
  }
  
}
