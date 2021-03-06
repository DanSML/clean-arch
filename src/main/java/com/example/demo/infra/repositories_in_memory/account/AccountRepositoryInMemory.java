package com.example.demo.infra.repositories_in_memory.account;

import java.util.ArrayList;

import com.example.demo.entites.account.Account;
import com.example.demo.infra.ports.GenerateAuthToken;
import com.example.demo.usecases.account.IAccountRepository;

public class AccountRepositoryInMemory implements IAccountRepository<Account> {
  GenerateAuthToken authGenerator = new GenerateAuthToken();
  private ArrayList<Account> accountsList = new ArrayList<Account>();
  private static AccountRepositoryInMemory accountsInstance;
  private static Account activeAccount;

  private AccountRepositoryInMemory() {
    accountsInstance = null;
  }
  
  public static AccountRepositoryInMemory getAccountInstance() {
    if (accountsInstance == null) {
      accountsInstance = new AccountRepositoryInMemory();
    }
    return accountsInstance;
  }

  @Override
  public void setLoggedAccountNull() {
    if (activeAccount != null) {
      activeAccount = null;
    }
  }

  @Override
  public void initiateAccountSection(Account account) {
    if (activeAccount == null) {
      Account loggedSection = findByEmail(account.email);
      activeAccount = loggedSection;
      activeAccount.setAuthToken(authGenerator.exec());
    }
  }

  @Override
  public Account getLoggedAccount() {
    return activeAccount;
  }

  @Override
  public void save(Account account) {
    accountsList.add(account);
  }

  @Override
  public Account findByUuid(String uuid) {
    Account accountFound;
    for (Account account : accountsList) {
      if (account.uuid.equals(uuid)) {
        accountFound = account;
        return accountFound;
      }
    }
    return null;
  }

  @Override
  public ArrayList<Account> findAll() {
    return this.accountsList;
  }

  @Override
  public Account findByEmail(String email) {
    Account accountFound;
    for (Account account : accountsList) {
      if (account.email.equals(email)) {
        accountFound = account;
        return accountFound;
      }
    }
    return null;
  }

  @Override
  public void delete(String uuid) {
  }

  @Override
  public Account update(Account any) {
    return null;
  }
}
