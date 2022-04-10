package com.example.demo.adapters.controllers.account;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.dto.account.ChangeEmailDTO;

public class ChangeEmailController extends BaseController<ChangeEmailDTO> {
  BaseUseCase<ChangeEmailDTO> changeAccountEmail;

  public ChangeEmailController(BaseUseCase<ChangeEmailDTO> changeAccountEmail) {
    super(changeAccountEmail);
    this.changeAccountEmail = changeAccountEmail;
  }

  @Override
  public Object handle(Object request) throws Exception, Throwable {
    Object response = changeAccountEmail.exec(request);
    return response;
  }
}
