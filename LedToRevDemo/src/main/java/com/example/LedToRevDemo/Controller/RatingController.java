package com.example.LedToRevDemo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LedToRevDemo.Entity.Rating;
import com.example.LedToRevDemo.Repository.RatingRepo;

@RestController
public class RatingController {

	@Autowired
	private RatingRepo ratingRepo;
	
	     @GetMapping("/allrating")
         public List<Rating> getAllRating() { 
     	 List<Rating> ratings = ratingRepo.findAll(); 
	     return ratings;
	     }
	
	   @GetMapping("/rating/{id}")
	    public ResponseEntity<Rating> getRating(@PathVariable int id) {
	    Optional<Rating> optionalRating = ratingRepo.findById(id);
	    if (optionalRating.isPresent()) {
	    return ResponseEntity.ok(optionalRating.get());
	    } 
	    else {
	    return ResponseEntity.notFound().build();
	    }
	    }
	   
	    @PostMapping("/rating/add")
	    public void Createrating(@RequestBody Rating rating) {
	    ratingRepo.save(rating);
	    }	  
	    
	    @PutMapping("/rating/update/{id}")
	    public Rating updaterating(@PathVariable int id) {
	    Rating rating =ratingRepo.findById(id).get();
	    rating.setRating (8.3);
	    rating.setComment("its great ");
	    return rating;
	    }
	    
	    @DeleteMapping("/rating/delete/{id}")
	    public void removerating(@PathVariable int id) {
	    Rating rating =ratingRepo.findById((int) id).get();
	    ratingRepo.delete(rating);
	    }
}
