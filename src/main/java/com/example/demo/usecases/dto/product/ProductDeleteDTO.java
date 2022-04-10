package com.example.demo.usecases.dto.product;

public class ProductDeleteDTO {
  public String uuid;
  public ProductDeleteDTO(String uuid){
    this.uuid = uuid;
  }
  public String getUuid() {
    return uuid;
  }
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
}
