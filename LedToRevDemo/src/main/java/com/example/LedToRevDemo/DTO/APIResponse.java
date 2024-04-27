package com.example.LedToRevDemo.DTO;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.LedToRevDemo.Entity.Product;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<T> {
    private int recordCount;
    private T response;
    
    public APIResponse(int recordCount, List<Product> response) {
        this.recordCount = recordCount;
        this.response = (T) response;
    }
    
    
    private int size;
    private T data;

    public APIResponse(int size, T data) {
        this.size = size;
        this.data = data;
    }

    public APIResponse(Page<Product> page) {
        this.size = page.getSize();
        this.data = (T) page;
    }

}

