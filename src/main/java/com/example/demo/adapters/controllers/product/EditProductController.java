package com.example.demo.adapters.controllers.product;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.entites.product.Product;

public class EditProductController extends BaseController<Product> {
  BaseUseCase<Product> editProduct;

  public EditProductController(BaseUseCase<Product> editProduct) {
    super(editProduct);
    this.editProduct = editProduct;
  }

  @Override
  public Object handle(Object request) throws Exception, Throwable {
    Object response = editProduct.exec(request);
    return response;
  }
}
