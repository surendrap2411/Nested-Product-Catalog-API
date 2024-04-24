package com.example.SainugenAces_PLTT.Controller;

import java.util.List;
import com.example.SainugenAces_PLTT.DTO.APIResponse;
import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.SainugenAces_PLTT.Entity.Product;
import com.example.SainugenAces_PLTT.Repository.ProductRepository;
import com.example.SainugenAces_PLTT.Service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {
	
    
	 @Autowired
    private ProductRepository repo;
    
    @Autowired
    private ProductService service;
    
    @GetMapping("/count")
    public String getAllProductss() {
        List<Product> products = service.findAllProduct();
        int productCount = products.size();
        StringBuilder response = new StringBuilder();
        response.append("Total Products: ").append(productCount).append("\n");
        for (Product product : products) {
            response.append(product.toString()).append("\n");
        }
        return response.toString();
    }
    
 
	/*
	 * @GetMapping(value = "/allproducts/name", produces =
	 * MediaType.APPLICATION_JSON_VALUE) private APIResponse<List<Product>>
	 * getProductsWithSort(@PathVariable String field) { List<Product> allProducts =
	 * service.findProductSorting(field); return new
	 * APIResponse<>(allProducts.size(), allProducts); }
	 */


    @GetMapping("/allproducts")   
    public List<Product> getAllProducts() {
    List<Product> products = repo.findAll();
    return products;   
    }
    
    @GetMapping("/allproducts/{id}")
    public Product getProduct(@PathVariable int id) {
    Product product = repo.findById(id).get(); 
    return product;
    }
    
    @PostMapping("/product/add")
    public void CreatePoduct(@RequestBody Product product) {
    repo.save(product);
    }
    
    @PutMapping("/product/update/{id}")
    public Product updateproduct(@PathVariable int id) {
    Product product =repo.findById(id).get();
    product.setName("surendra");
    product.setPrice(111);
    return product;
    }
    
    @DeleteMapping("/deleteproduct/{id}")
    public void removeProduct(@PathVariable int id) {
    Product product =repo.findById(id).get();
    repo.delete(product);
    }
      
    @GetMapping(value = "/allproducts/sort/{field}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductsWithSort(@PathVariable String field) {
        List<Product> sortedProducts = service.findProductSorting(field);
        if (sortedProducts != null && !sortedProducts.isEmpty()) {
            return ResponseEntity.ok(sortedProducts);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    
	/*
	 * @GetMapping("/pagination/{offset}/{pageSize}") public
	 * APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int
	 * offset, @PathVariable int pageSize) { Page<Product> productsWithPagination =
	 * service.findproductsWithPagination(offset, pageSize); return new
	 * APIResponse<Page<Product>>(productsWithPagination.getSize(),
	 * productsWithPagination); }
	 */


   
    
    @GetMapping("/pagination/{offset}/{pageSize}")
    public ResponseEntity<Page<Product>> getProductsWithPagination(
            @PathVariable int offset, @PathVariable int pageSize) {
        Page<Product> productsWithPagination = service.findproductsWithPagination(offset, pageSize);
        
        if (productsWithPagination != null && !productsWithPagination.isEmpty()) {
            return ResponseEntity.ok(productsWithPagination);
        } else {
            // Log a message indicating empty result set
            System.out.println("No products found for pagination request with offset: " + offset + " and pageSize: " + pageSize);
            
            // Return a response with HTTP status indicating no content
            return ResponseEntity.noContent().build();
        }
    }
}
