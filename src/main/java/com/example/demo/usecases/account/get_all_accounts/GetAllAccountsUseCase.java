package com.example.demo.usecases.account.get_all_accounts;

import com.example.demo.infra.repositories_in_memory.account.AccountRepositoryInMemory;
import com.example.demo.usecases.BaseUseCase;

public class GetAllAccountsUseCase implements BaseUseCase {
  AccountRepositoryInMemory accountRepositoryInMemory;

  public GetAllAccountsUseCase(AccountRepositoryInMemory accountRepositoryInMemory) {
    this.accountRepositoryInMemory = accountRepositoryInMemory;
  }

  @Override
  public Object exec(Object any) throws Exception, Throwable {
    return accountRepositoryInMemory.findAll();
  }
  
}
