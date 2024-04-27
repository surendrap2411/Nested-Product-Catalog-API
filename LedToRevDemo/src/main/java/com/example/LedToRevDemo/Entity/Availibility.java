package com.example.LedToRevDemo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="AvailbilityTable")
public class Availibility {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @Column
    private boolean Instock;
    
    @Column
    private int quantity;
  
  
    @OneToOne
    @JoinColumn(name="product_id")
    @JsonIgnore
	private Product product;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public boolean isInstock() {
		return Instock;
	}


	public void setInstock(boolean instock) {
		Instock = instock;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Availibility(Long id, boolean instock, int quantity, Product product) {
		super();
		this.id = id;
		Instock = instock;
		this.quantity = quantity;
		this.product = product;
	}	
     public Availibility() {}
    
}
