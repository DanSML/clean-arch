package com.example.demo.adapters.controllers.account;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.usecases.BaseUseCase;

public class LogInController extends BaseController {
  BaseUseCase logIn;

  public LogInController(BaseUseCase logIn) {
    super(logIn);
    this.logIn = logIn;
  }

  public Object handle(Object request) throws Exception, Throwable {
    Object result = logIn.exec(request);
    return result;
  }
}
