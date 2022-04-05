package com.example.demo.adapters.controllers.product;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.usecases.BaseUseCase;

public class CreateProductController extends BaseController {
  BaseUseCase createProduct;

  public CreateProductController(BaseUseCase createProduct) {
    super(createProduct);
    this.createProduct = createProduct;
  }

  @Override
  public Object handle(Object request) throws Exception, Throwable {
    Object result = createProduct.exec(request);
    return result;
  }
}
