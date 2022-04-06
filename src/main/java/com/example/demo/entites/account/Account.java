package com.example.demo.entites.account;

import java.util.UUID;

public class Account {
  public String uuid;
  public String name;
  public String role;
  public String email;
  public String password;
  public Account(String name, String email, String role, String password) {
    UUID uuid = UUID.randomUUID();
    this.uuid = uuid.toString();
    this.name = name;
    this.email = email;
    this.role = role;
    this.password = password;
  }
  public String getEmail() {
    return this.email;
  }
  public String getUuid() {
    return this.uuid;
  }
  public String getPassword() {
    return this.password;
  }
  public String getName() {
    return this.name;
  }
  public String getRole() {
    return this.role;
  }
  public void setPassword(String password) {
    this.password = password;    
  }
	public void setUuid(String uuid) {
    this.uuid = uuid;
	}
	public void setEmail(String email) {
    this.email = email;
	}
  public void setName(String name) {
    this.name = name;
  }
  public void setRole(String role) {
    this.role = role;
  }
	public Account takeBasicData() {
		return this;
	}
}
