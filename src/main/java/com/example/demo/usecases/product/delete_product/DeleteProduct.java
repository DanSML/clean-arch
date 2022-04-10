package com.example.demo.usecases.product.delete_product;

import com.example.demo.entites.account.Account;
import com.example.demo.entites.product.Product;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.account.IAccountRepository;
import com.example.demo.usecases.dto.product.ProductDeleteDTO;
import com.example.demo.usecases.errors.ErrorHandler;
import com.example.demo.usecases.product.IProductRepository;

public class DeleteProduct implements BaseUseCase<ProductDeleteDTO> {
  IProductRepository<Product> productRepository;
  IAccountRepository<Account> accountRepository;
  ErrorHandler err = new ErrorHandler();

  public DeleteProduct (
    IProductRepository<Product> productRepository,
    IAccountRepository<Account> accountRepository
  ) {
    this.productRepository = productRepository;
    this.accountRepository = accountRepository;
  }

  @Override
  public Object exec(Object any) throws Exception, Throwable {
    ProductDeleteDTO productToRemoveUUID = (ProductDeleteDTO) any;
    Product productFound = this.productRepository.findByUuid(productToRemoveUUID.uuid);

    try {
      if (this.accountRepository.getLoggedAccount() == null) 
        throw new DeleteProductException("Cannot delete a product without a logged section!");

      if (productFound == null)
        throw new DeleteProductException("Product does not exists on Database!");
      
      if (productFound.getStockQuantity() > 0)
        throw new DeleteProductException("Cannot delete a product data that still have itens on stock");

      this.productRepository.delete(productToRemoveUUID.uuid);

    } catch (DeleteProductException error) {
      err.setErrorLog(error);
      throw err;
    }
    return null;
  }
}
