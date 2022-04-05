package com.example.demo.adapters.controllers.account;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.usecases.BaseUseCase;

public class ResetPasswordController extends BaseController {
  BaseUseCase resetPassword;

  public ResetPasswordController(BaseUseCase resetPassword) {
    super(resetPassword);
    this.resetPassword = resetPassword;
  }

  public Object handle(Object request) throws Exception, Throwable {
    Object result = resetPassword.exec(request);
    return result;
  }
}
