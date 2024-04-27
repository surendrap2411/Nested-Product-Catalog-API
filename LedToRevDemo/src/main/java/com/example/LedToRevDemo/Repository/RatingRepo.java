package com.example.LedToRevDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LedToRevDemo.Entity.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating,Integer>{

	void save(RatingRepo ratingRepo);

}
