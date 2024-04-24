package com.example.SainugenAces_PLTT.Controller;
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

import com.example.SainugenAces_PLTT.Entity.Availability;
import com.example.SainugenAces_PLTT.Entity.Product;
import com.example.SainugenAces_PLTT.Entity.Rating; // Import Rating class
import com.example.SainugenAces_PLTT.Repository.RatingRepository;

@RestController
public class RatingController {
    @Autowired
    public RatingRepository rapo;
    
    @GetMapping("/allrating")
    public List<Rating> getAllRating() { 
        List<Rating> ratings = rapo.findAll(); 
        return ratings;
    }
    
    @GetMapping("/allrating/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable int id) {
    Optional<Rating> optionalRating = rapo.findById(id);
    if (optionalRating.isPresent()) {
    return ResponseEntity.ok(optionalRating.get());
    } 
    else {
    return ResponseEntity.notFound().build();
    }
    }
   
    @PostMapping("/rating/add")
    public void Createrating(@RequestBody Rating rating) {
    rapo.save(rating);
    }
    
    @PutMapping("/rating/update/{id}")
    public Rating updaterating(@PathVariable int id) {
    Rating rating =rapo.findById(id).get();
    rating.setRating (8.3);
    rating.setComment("its great ");
    return rating;
    }
    
    @DeleteMapping("/deleteRating/{id}")
    public void removerating(@PathVariable int id) {
    Rating rating =rapo.findById((int) id).get();
    rapo.delete(rating);
    }
    
}
