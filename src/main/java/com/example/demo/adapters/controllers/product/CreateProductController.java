package com.example.demo.adapters.controllers.product;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.entites.product.Product;
import com.example.demo.usecases.BaseUseCase;

public class CreateProductController extends BaseController<Product> {
  BaseUseCase<Product> createProduct;

  public CreateProductController(BaseUseCase<Product> createProduct) {
    super(createProduct);
    this.createProduct = createProduct;
  }

  @Override
  public Object handle(Object request) throws Exception, Throwable {
    Object response = createProduct.exec(request);
    return response;
  }
}
