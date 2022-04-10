package com.example.demo.usecases.product.edit_product;

import com.example.demo.entites.account.Account;
import com.example.demo.entites.product.Product;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.account.IAccountRepository;
import com.example.demo.usecases.errors.ErrorHandler;
import com.example.demo.usecases.product.IProductRepository;

public class EditProduct implements BaseUseCase<Product> {
  IProductRepository<Product> productRepository;
  IAccountRepository<Account> accountRepository;
  ErrorHandler err = new ErrorHandler();

  public EditProduct (
    IProductRepository<Product> productRepository,
    IAccountRepository<Account> accountRepository
  ) {
    this.productRepository = productRepository;
    this.accountRepository = accountRepository;
  }
  
  @Override
  public Object exec(Object productDTO) throws Exception, Throwable {
    Product productToEdit =  (Product) productDTO;
    Product foundProduct = this.productRepository.findByUuid(productToEdit.uuid);
    Product foundProductByName = this.productRepository.findByName(productToEdit.name);
    try {

      if (this.accountRepository.getLoggedAccount() == null) 
        throw new EditProductException("Cannot update a product without a logged section!");

      if (foundProduct == null) 
        throw new EditProductException("This product does not exists on data base");

      if (foundProductByName != null)
        if (!foundProductByName.uuid.equals(productToEdit.uuid))
          throw new EditProductException("A product with this name already exists on database");

      if (productToEdit.buyPrice > productToEdit.sellPrice)
        throw new EditProductException("Cannot create a product with buyPrice higher then sellPrice");

      if (productToEdit.type.length() <= 0 || productToEdit.type == null)
        throw new EditProductException("Type field cannot be empty");

      if (productToEdit.stockQuantity < 0)
        throw new EditProductException("StockQuantity field must be higher then 0");

    } catch (EditProductException error) {
      err.setErrorLog(error);
      throw err;
    }

    Product productEdited = this.productRepository.update(productToEdit);
    return productEdited;
  }
}
