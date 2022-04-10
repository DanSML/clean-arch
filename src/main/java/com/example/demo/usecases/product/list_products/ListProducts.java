package com.example.demo.usecases.product.list_products;

import java.util.ArrayList;
import com.example.demo.entites.account.Account;
import com.example.demo.entites.product.Product;
import com.example.demo.usecases.BaseUseCase;
import com.example.demo.usecases.account.IAccountRepository;
import com.example.demo.usecases.errors.ErrorHandler;
import com.example.demo.usecases.product.IProductRepository;

public class ListProducts implements BaseUseCase<Product> {
  IProductRepository<Product> productRepository;
  IAccountRepository<Account> accountRepository;
  ErrorHandler err = new ErrorHandler();

  public ListProducts (
    IProductRepository<Product> productRepository,
    IAccountRepository<Account> accountRepository
  ) {
    this.productRepository = productRepository;
    this.accountRepository = accountRepository;
  }

  @Override
  public Object exec(Object any) throws Exception, Throwable {
    try { 
      if (this.accountRepository.getLoggedAccount() == null) 
        throw new ListProductsException("Cannot list all products without a logged section!");
    } catch (ListProductsException error) {
      err.setErrorLog(error);
      throw err;
    }
    ArrayList<Product> products =  this.productRepository.findAll();
    return products;
  }
}
