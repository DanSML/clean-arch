package com.example.demo.entites.product;

public class Product {
  public String uuid;
  public String name;
  public String description;
  public String type;
  public int stockQuantity;
  public double buyPrice;
  public double sellPrice;
  public Product(
      String name, 
      String description, 
      String type, 
      int stockQuantity, 
      double buyPrice,
      double sellPrice
    ) {
    this.name = name;
    this.description = description;
    this.type = type;
    this.stockQuantity = stockQuantity;
    this.buyPrice = buyPrice;
    this.sellPrice = sellPrice;
  }
  public String getUuid() {
    return uuid;
  }
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public int getStockQuantity() {
    return stockQuantity;
  }
  public void setStockQuantity(int stockQuantity) {
    this.stockQuantity = stockQuantity;
  }
  public double getBuyPrice() {
    return buyPrice;
  }
  public void setBuyPrice(double buyPrice) {
    this.buyPrice = buyPrice;
  }
  public double getSellPrice() {
    return sellPrice;
  }
  public void setSellPrice(double sellPrice) {
    this.sellPrice = sellPrice;
  }
}
