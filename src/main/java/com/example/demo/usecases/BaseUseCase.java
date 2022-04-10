package com.example.demo.usecases;

public interface BaseUseCase<T> {
  public Object exec(Object any) throws Exception, Throwable;
}
