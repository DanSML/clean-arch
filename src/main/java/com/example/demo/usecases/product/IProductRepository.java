package com.example.demo.usecases.product;

import java.util.ArrayList;

public interface IProductRepository<T> {
  public void delete(String uuid);
  public T update(T any);
  public void save(T any);
  public T findByUuid(String uuid);
  public ArrayList<T> findAll();
  public T findByName(String name);
}
