package com.example.demo.infra.repositories_in_memory.product;

import java.util.ArrayList;

import com.example.demo.entites.product.Product;
import com.example.demo.infra.repositories_in_memory.BaseRepositoryInMemory;

public class ProductRepositoryInMemory implements BaseRepositoryInMemory<Product> {
  private ArrayList<Product> productList = new ArrayList<Product>();
  private static ProductRepositoryInMemory productInstance;

  private ProductRepositoryInMemory() {
    productInstance = null;
  }

  public static ProductRepositoryInMemory getProductInstance() {
    if (productInstance == null) {
      productInstance = new ProductRepositoryInMemory();
    }
    return productInstance;
  }

  @Override
  public void delete(String uuid) {
    for (Product product : productList) {
      if (product.uuid.equals(uuid)){
        productList.remove(product);
      }
    }
  }

  @Override
  public Product update(Product productToUpdate) {
    for (Product product : productList) {
      if (productToUpdate.uuid.equals(product.uuid)){
        product = productToUpdate;
        return product;
      }
    }
    return null;
  }

  @Override
  public void save(Product newProduct) {
    this.productList.add(newProduct);
  }

  public Product findByName(String name) {
    for (Product product : productList) {
      if (product.name.equals(name)) {
        return product;
      }
    }
    return null;
  }

  @Override
  public Product findByUuid(String uuid) {
    for (Product product : productList) {
      if (product.uuid.equals(uuid)) {
        return product;
      }
    }
    return null;
  }

  @Override
  public ArrayList<Product> findAll() {
    return productList;
  }
  
}
