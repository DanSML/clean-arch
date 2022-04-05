package com.example.demo.main.routes;

import com.example.demo.adapters.controllers.product.CreateProductController;
import com.example.demo.entites.product.Product;
import com.example.demo.main.factories.ProductFactory;
import com.example.demo.usecases.errors.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductRoute {
  ProductFactory productFactory = new ProductFactory();
  CreateProductController createProductController = productFactory.createProductController();

  @PostMapping("/create-product")
  public ResponseEntity<?> createProduct(@RequestBody Product newProduct) throws Exception, Throwable {
    try {
      Object response = createProductController.handle(newProduct);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (ErrorHandler err) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrorLog());
    }
  }
}
