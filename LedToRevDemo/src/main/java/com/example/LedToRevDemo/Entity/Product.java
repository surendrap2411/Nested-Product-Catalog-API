package com.example.LedToRevDemo.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ProductDetail")

public class Product {
    @Id	
    @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
    
    @Column
    private String name;
    
    @Column
    private String desciption;
    @Column
    private double price;
    @Column
    private String categories;
    @Column    
    private String attributes;
    
    @OneToOne(mappedBy="product",cascade=CascadeType.ALL)
    
    private Availibility availibility;
    
    @OneToMany(mappedBy="product",cascade=CascadeType.ALL)
    
    private List<Rating> rating;
    
   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public Availibility getAvailibility() {
		return availibility;
	}

	public void setAvailibility(Availibility availibility) {
		this.availibility = availibility;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public Product(Long id, String name, String desciption, double price, String categories, String attributes,
			Availibility availibility, List<Rating> rating) {
		super();
		this.id = id;
		name = name;
		this.desciption = desciption;
		this.price = price;
		this.categories = categories;
		this.attributes = attributes;
		this.availibility = availibility;
		this.rating = rating;
	}
    
   
    public Product() {}
    
    
}
