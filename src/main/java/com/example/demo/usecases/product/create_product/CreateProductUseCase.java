package com.example.demo.usecases.product.create_product;

import com.example.demo.entites.product.Product;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.errors.ErrorHandler;
import com.example.demo.usecases.product.IProductRepository;

public class CreateProductUseCase implements BaseUseCase {
  IProductRepository<Product> productRepository;
  ErrorHandler err = new ErrorHandler();

  public CreateProductUseCase(IProductRepository<Product> productRepository) {
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

    this.productRepository.save(product);
    return product;
  }
}
