package com.example.demo.main.factories;

import com.example.demo.adapters.controllers.product.CreateProductController;
import com.example.demo.infra.repositories_in_memory.product.ProductRepositoryInMemory;
import com.example.demo.usecases.product.create_product.CreateProductUseCase;

public class ProductFactory {
  ProductRepositoryInMemory productRepository = ProductRepositoryInMemory.getProductInstance();

  public CreateProductController createProductController() {
    CreateProductUseCase createProductUseCase = new CreateProductUseCase(productRepository);
    CreateProductController createProductController = new CreateProductController(createProductUseCase);

    return createProductController;
  }
}
