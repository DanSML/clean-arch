package com.example.demo.adapters.controllers;

import com.example.demo.usecases.BaseUseCase;

public abstract class BaseController<T> {
  public BaseController(BaseUseCase<T> useCase) {}

  public abstract Object handle(Object request)  throws Exception, Throwable ;
}
