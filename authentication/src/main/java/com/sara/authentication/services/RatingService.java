package com.sara.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sara.authentication.models.Rating;
import com.sara.authentication.models.Show;
import com.sara.authentication.repositories.RatingRepository;

@Service
public class RatingService {
private final RatingRepository ratingRepository;
	
	public RatingService(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}
	
	public List<Rating> findRatingsByShow(Show show){
		return ratingRepository.findByShowOrderByValueAsc(show);
	}
	
	public List<Rating> allRatings(){
		return ratingRepository.findAll();
	}
	
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}
	
	public Rating findRating(Long id) {
		Optional<Rating> optionalRating = ratingRepository.findById(id);
		if(optionalRating.isPresent()) {
			return optionalRating.get();
		} else {
			return null;
		}
	}
	
	public List<Object[]> avg(){
		List<Object[]> avg_rate =  ratingRepository.avg();
		return avg_rate;
	}
}
