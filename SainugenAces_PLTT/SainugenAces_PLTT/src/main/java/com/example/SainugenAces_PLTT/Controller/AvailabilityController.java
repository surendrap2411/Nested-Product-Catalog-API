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
import com.example.SainugenAces_PLTT.Entity.Rating;
import com.example.SainugenAces_PLTT.Repository.AvaailabilityRepository;

@RestController
public class AvailabilityController {

    @Autowired
    private AvaailabilityRepository avrepo; // Corrected repository name

    @GetMapping("/availability")
    public List<Availability> getAllAvailability() { 
        List<Availability> availabilities = avrepo.findAll(); 
        return availabilities;
    }
    
    @GetMapping("/availability/{id}")
    public ResponseEntity<Availability> getAvailability(@PathVariable Long id) {
       Optional<Availability> optionalAvailability = avrepo.findById(id);
        if (optionalAvailability.isPresent()) {
            return ResponseEntity.ok(optionalAvailability.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/addavailability")
    public void createAvailability(@RequestBody Availability availability) {
    avrepo.save(availability);    
    }
    
    @PutMapping("/availability/update/{id}")
    public Availability updaterating(@PathVariable int id) {
    Availability availability =avrepo.findById((long) id).get();
    availability.setQuantity (8);
    return availability;
    }
    
    
    @DeleteMapping("/deleteAvailability/{id}")
    public void removeAvailability(@PathVariable int id) {
    Availability availability =avrepo.findById((long) id).get();
    avrepo.delete(availability);
    }
}
