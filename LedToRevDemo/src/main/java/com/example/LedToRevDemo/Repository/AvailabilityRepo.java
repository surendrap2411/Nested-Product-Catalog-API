package com.example.LedToRevDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LedToRevDemo.Entity.Availibility;

@Repository
public interface AvailabilityRepo extends JpaRepository<Availibility,Long>{

}
