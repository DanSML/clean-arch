package com.example.demo.adapters.controllers.product;

import com.example.demo.adapters.controllers.BaseController;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.dto.product.ProductDeleteDTO;

public class DeleteProductController extends BaseController<ProductDeleteDTO> {
  BaseUseCase<ProductDeleteDTO> deleteProduct;

  public DeleteProductController(BaseUseCase<ProductDeleteDTO> deleteProduct) {
    super(deleteProduct);
    this.deleteProduct = deleteProduct;
  }

  @Override
  public Object handle(Object request) throws Exception, Throwable {
    Object response = deleteProduct.exec(request);
    return response;
  }
}
