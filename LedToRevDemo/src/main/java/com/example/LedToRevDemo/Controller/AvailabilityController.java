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

import com.example.LedToRevDemo.Entity.Availibility;
import com.example.LedToRevDemo.Repository.AvailabilityRepo;


@RestController
public class AvailabilityController {

	@Autowired
	private AvailabilityRepo availabilityRepo;
	
	
	
    @GetMapping("/availability")
    public List<Availibility> getAllAvailability() { 
        List<Availibility> availabilities = availabilityRepo.findAll(); 
        return availabilities;
    }
    
    @GetMapping("/availability/{id}")
    public ResponseEntity<Availibility> getAvailability(@PathVariable Long id) {
    Optional<Availibility> optionalAvailability = availabilityRepo.findById(id);
    if (optionalAvailability.isPresent()) {
    return ResponseEntity.ok(optionalAvailability.get());
    } else {
    return ResponseEntity.notFound().build();
    }
    }
    
    @PostMapping("/addavailability")
    public void createAvailability(@RequestBody Availibility availability) {
    availabilityRepo.save(availability);    
    }
    
    @PutMapping("/availability/update/{id}")
    public Availibility updaterating(@PathVariable int id) {
    Availibility availability=availabilityRepo.findById((long) id).get();
    availability.setQuantity (8);
    return availability;
    }
    
    
    @DeleteMapping("/availability/delete/{id}")
    public void removeAvailability(@PathVariable int id) {
    Availibility availability =availabilityRepo.findById((long) id).get();
    availabilityRepo.delete(availability);
    }
	
}
