package com.example.demo.adapters.controllers.account;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.usecases.BaseUseCase;

public class ChangePasswordController extends BaseController<Object> {
  BaseUseCase<Object> changePassword;

  public ChangePasswordController(BaseUseCase<Object> changePassword) {
    super(changePassword);
    this.changePassword = changePassword;
  }

  @Override
  public Object handle(Object request) throws Exception, Throwable {
    Object response = changePassword.exec(request);
    return response;
  }
}
