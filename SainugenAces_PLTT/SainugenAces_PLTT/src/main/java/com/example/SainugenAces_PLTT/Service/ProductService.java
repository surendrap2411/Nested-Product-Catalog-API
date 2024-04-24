package com.example.SainugenAces_PLTT.Service;
import org.springframework.data.domain.Page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.SainugenAces_PLTT.Entity.Product;
import com.example.SainugenAces_PLTT.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    
    public List<Product> findAllProduct() {
        return repository.findAll();
    }
    
    public int getProductCount() {
        return repository.findAll().size();
    }
    
    public List<Product> findProductSorting(String field){
        return repository.findAll(Sort.by(Sort.Direction.ASC, field));
    }
    
   
      
      public Page<Product> findproductsWithPagination(int offset, int pageSize){
          return repository.findAll(PageRequest.of(offset, pageSize));
      }
    }

