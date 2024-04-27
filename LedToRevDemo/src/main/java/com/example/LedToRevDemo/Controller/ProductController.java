package com.example.LedToRevDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LedToRevDemo.Entity.Product;
import com.example.LedToRevDemo.Repository.ProductRepo;
import com.example.LedToRevDemo.Service.ProductService;

@RestController
public class ProductController {
	 @Autowired
	  private ProductService service;
	
	@Autowired
    private	ProductRepo productRepo;
	
	@GetMapping("/products")
     public List<Product> getAllProduct(){
	 List<Product>products = productRepo.findAll();
	 return products;	
	}
	
	 @GetMapping("/products/{id}")
	 public Product getProduct(@PathVariable int id) {
	 Product product = productRepo.findById((long) id).get(); 
	 return product;
	 }
	 
	 @PostMapping("/products/add")
	  public void CreatePoduct(@RequestBody Product product) {
	 productRepo.save(product);
	  }
	
	 @PutMapping("/products/update/{id}")
	 public Product updateproduct(@PathVariable int id) {
	 Product product =productRepo.findById((long) id).get();
	 product.setName("superr product");
	 product.setPrice(1);
	 return product;
	 }
	 
	 @DeleteMapping("/products/delete/{id}")
	  public void removeProduct(@PathVariable int id) {
	  Product product =productRepo.findById((long) id).get();
	  productRepo.delete(product);
	  }
	 
	 @GetMapping(value = "/products/sort/{field}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<Product>> getProductsWithSort(@PathVariable String field) {
	 List<Product> sortedProducts = service.findProductSorting(field);
	 if (sortedProducts != null && !sortedProducts.isEmpty()) {
	 return ResponseEntity.ok(sortedProducts);
	 } else {
	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 }
	 }
	 
	  @GetMapping("/pagination/{offset}/{pageSize}")
	  public ResponseEntity<Page<Product>> getProductsWithPagination(
	  @PathVariable int offset, @PathVariable int pageSize) {
	  Page<Product> productsWithPagination = service.findproductsWithPagination(offset, pageSize);
	        
	  if (productsWithPagination != null && !productsWithPagination.isEmpty()) {
	  return ResponseEntity.ok(productsWithPagination);
	  } else {
	  return ResponseEntity.noContent().build();
	  }
	  }
}
