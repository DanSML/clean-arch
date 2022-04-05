package com.example.demo.usecases.product.create_product;

import java.util.UUID;

import com.example.demo.entites.product.Product;
import com.example.demo.infra.repositories_in_memory.product.ProductRepositoryInMemory;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.errors.ErrorHandler;

public class CreateProductUseCase implements BaseUseCase {
  ProductRepositoryInMemory productRepository;
  ErrorHandler err = new ErrorHandler();

  public CreateProductUseCase(ProductRepositoryInMemory productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Object exec(Object newProduct) throws ErrorHandler {
    Product test = (Product) newProduct;
    // try {

    // } catch () {

    // } 
    Product product = new Product(
      test.name, 
      test.description, 
      test.type, 
      test.stockQuantity, 
      test.buyPrice, 
      test.sellPrice
    );
    UUID uuid = UUID.randomUUID();
    product.setUuid(uuid.toString());
    this.productRepository.save(product);
    return product;
  }
}
