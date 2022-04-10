package com.example.demo.main.factories;

import com.example.demo.adapters.controllers.product.CreateProductController;
import com.example.demo.adapters.controllers.product.DeleteProductController;
import com.example.demo.adapters.controllers.product.EditProductController;
import com.example.demo.adapters.controllers.product.ListProductsController;
import com.example.demo.infra.repositories_in_memory.account.AccountRepositoryInMemory;
import com.example.demo.infra.repositories_in_memory.product.ProductRepositoryInMemory;
import com.example.demo.usecases.product.create_product.CreateProduct;
import com.example.demo.usecases.product.delete_product.DeleteProduct;
import com.example.demo.usecases.product.edit_product.EditProduct;
import com.example.demo.usecases.product.list_products.ListProducts;

public class ProductFactory {
  ProductRepositoryInMemory productRepository = ProductRepositoryInMemory.getProductInstance();
  AccountRepositoryInMemory accountRepository = AccountRepositoryInMemory.getAccountInstance();

  public CreateProductController createProductController() {
    CreateProduct createProductUseCase = new CreateProduct(productRepository, accountRepository);
    CreateProductController createProductController = new CreateProductController(createProductUseCase);

    return createProductController;
  }

  public EditProductController editProductControllerFactory() {
    EditProduct editProduct = new EditProduct(productRepository, accountRepository);
    EditProductController editProductController = new EditProductController(editProduct);

    return editProductController;
  }

  public ListProductsController listProductsControllerFactory() {
    ListProducts listProducts = new ListProducts(productRepository, accountRepository);
    ListProductsController listProductsController = new ListProductsController(listProducts);

    return listProductsController;
  }

  public DeleteProductController deleteProductControllerFactory() {
    DeleteProduct deleteProduct = new DeleteProduct(productRepository, accountRepository);
    DeleteProductController deleteProductController = new DeleteProductController(deleteProduct);

    return deleteProductController;
  }
}
