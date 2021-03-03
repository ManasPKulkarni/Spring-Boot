package com.devSense.movieCatalogue.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devSense.movieCatalogue.models.Rating;
import com.devSense.movieCatalogue.models.UserRatings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingService {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRatings getUserRating(String userId) {
		return restTemplate.getForObject("http://rating-service/ratingsdata/users/" + userId, UserRatings.class);
	}
	
	public UserRatings getFallbackUserRating(String userId) {
		UserRatings userRatings = new UserRatings();
		userRatings.setUserId(userId);
		userRatings.setUserRating(Arrays.asList(new Rating( "0",0.0)));
		return userRatings;
	}
}
