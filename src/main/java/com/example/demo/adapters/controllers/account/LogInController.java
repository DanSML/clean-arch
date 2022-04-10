package com.example.demo.adapters.controllers.account;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.dto.account.LogInDTO;

public class LogInController extends BaseController<LogInDTO> {
  BaseUseCase<LogInDTO> logIn;

  public LogInController(BaseUseCase<LogInDTO> logIn) {
    super(logIn);
    this.logIn = logIn;
  }

  @Override
  public Object handle(Object request) throws Exception, Throwable {
    Object result = logIn.exec(request);
    return result;
  }
}
