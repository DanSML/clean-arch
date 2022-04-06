package com.example.demo.usecases.account;
import java.util.ArrayList;

public interface IAccountRepository<T> {
  public void delete(String uuid);
  public T update(T any);
  public void save(T any);
  public T findByUuid(String uuid);
  public T findByEmail(String email);
  public ArrayList<T> findAll();
}
