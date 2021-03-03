package com.devSense.ratingService.models;

import java.util.List;

public class UserRatings {

	private List<Rating> userRating;

	@Override
	public String toString() {
		return "UserRatings [userRating=" + userRating + "]";
	}

	public UserRatings(List<Rating> userRating) {
		super();
		this.userRating = userRating;
	}

	public UserRatings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
	
}
