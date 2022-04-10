package com.example.demo.main.routes;

import com.example.demo.adapters.controllers.product.CreateProductController;
import com.example.demo.adapters.controllers.product.DeleteProductController;
import com.example.demo.adapters.controllers.product.EditProductController;
import com.example.demo.adapters.controllers.product.ListProductsController;
import com.example.demo.entites.product.Product;
import com.example.demo.main.factories.ProductFactory;
import com.example.demo.usecases.dto.product.ProductDeleteDTO;
import com.example.demo.usecases.errors.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductRoute {
  ProductFactory productFactory = new ProductFactory();
  CreateProductController createProductController = productFactory.createProductController();
  EditProductController editProductController = productFactory.editProductControllerFactory();
  ListProductsController listProductsController = productFactory.listProductsControllerFactory();
  DeleteProductController deleteProductController = productFactory.deleteProductControllerFactory();

  @PostMapping("/create-product")
  public ResponseEntity<?> createProduct(@RequestBody Product newProduct) throws Exception, Throwable {
    try {
      Object response = createProductController.handle(newProduct);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (ErrorHandler err) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrorLog());
    }
  }

  @PutMapping("/edit-product")
  public ResponseEntity<?> editProduct(@RequestBody Product productToEdit) throws Exception, Throwable {
    try {
      Object response = editProductController.handle(productToEdit);
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (ErrorHandler err) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrorLog());
    }
  }

  @GetMapping("/products")
  public ResponseEntity<?> getProducts() throws Exception, Throwable {
    try {
      Object response = listProductsController.handle(null);
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (ErrorHandler err) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrorLog());
    }
  }

  @DeleteMapping("/delete-product")
  public ResponseEntity<?> deleteProduct(@RequestBody ProductDeleteDTO productToDelete) throws Exception, Throwable {
    try {
      Object response = deleteProductController.handle(productToDelete);
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (ErrorHandler err) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getErrorLog());
    }
  }
}
