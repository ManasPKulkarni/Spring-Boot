package com.devSense.ratingService.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devSense.ratingService.models.Rating;
import com.devSense.ratingService.models.UserRatings;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 7.6);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRatings getRatingsByUser(@PathVariable("userId") String userId){
		
		List<Rating> ratings =  Arrays.asList(
				new Rating("Men Of Honor", 7.9),
				new Rating("Sully", 7.1)
				);
		
		UserRatings userRatings = new UserRatings();
		userRatings.setUserRating(ratings);
		
		return userRatings;
		
	}
}
