package com.example.demo.adapters.controllers.product;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.entites.product.Product;
import com.example.demo.usecases.BaseUseCase;

public class ListProductsController extends BaseController<Product> {
  BaseUseCase<Product> listProducts;

  public ListProductsController(BaseUseCase<Product> listProducts) {
    super(listProducts);
    this.listProducts = listProducts;
  }

  @Override
  public Object handle(Object request) throws Exception, Throwable {
    Object response = listProducts.exec(request);
    return response;
  }
}
