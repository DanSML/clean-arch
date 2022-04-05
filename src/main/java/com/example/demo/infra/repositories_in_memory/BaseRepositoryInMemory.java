package com.example.demo.infra.repositories_in_memory;
import java.util.ArrayList;

public interface BaseRepositoryInMemory<T> {
  public void delete(String uuid);
  public T update(T any);
  public void save(T any);
  public T findByUuid(String uuid);
  public ArrayList<T> findAll();
}
