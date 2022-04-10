package com.example.demo.usecases.product.create_product;

import com.example.demo.entites.account.Account;
import com.example.demo.entites.product.Product;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.account.IAccountRepository;
import com.example.demo.usecases.errors.ErrorHandler;
import com.example.demo.usecases.product.IProductRepository;

public class CreateProduct implements BaseUseCase<Product> {
  IProductRepository<Product> productRepository;
  IAccountRepository<Account> accountRepository;
  ErrorHandler err = new ErrorHandler();

  public CreateProduct(
    IProductRepository<Product> productRepository,
    IAccountRepository<Account> accountRepository
  ) {
    this.productRepository = productRepository;
    this.accountRepository = accountRepository;
  }

  @Override
  public Object exec(Object newProduct) throws ErrorHandler {
    Product productModel = (Product) newProduct;
    
    try {

      if (this.accountRepository.getLoggedAccount() == null) 
        throw new CreateProductException("Cannot create a product without a logged section!");

      if (this.productRepository.findByName(productModel.name) != null)
        throw new CreateProductException("A product with this name already exists on database");

      if (productModel.buyPrice > productModel.sellPrice)
        throw new CreateProductException("Cannot create a product with buyPrice higher then sellPrice");

      if (productModel.type.length() <= 0 || productModel.type == null)
        throw new CreateProductException("Type field cannot be empty");

      if (productModel.stockQuantity < 0)
        throw new CreateProductException("StockQuantity field must be higher then 0");

    } catch (CreateProductException error) {
      err.setErrorLog(error);
      throw err;
    } 

    Product product = new Product(
      productModel.name, 
      productModel.description, 
      productModel.type, 
      productModel.stockQuantity, 
      productModel.buyPrice, 
      productModel.sellPrice
    );

    product.setUuid(productModel.uuid);

    this.productRepository.save(product);
    return productModel;
  }
}
