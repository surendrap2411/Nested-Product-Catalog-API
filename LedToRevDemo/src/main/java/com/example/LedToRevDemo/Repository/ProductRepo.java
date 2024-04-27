package com.example.LedToRevDemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LedToRevDemo.Entity.Product;
import com.example.LedToRevDemo.Entity.Rating;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

	List<Product> findAll();

	



}
