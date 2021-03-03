package com.devSense.movieCatalogue.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.devSense.movieCatalogue.models.CatalogItem;
import com.devSense.movieCatalogue.models.Movie;
import com.devSense.movieCatalogue.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatlogItem(String DescSully, Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getMovieName(), DescSully, rating.getRating());
	}
	
	public CatalogItem getFallbackCatalogItem(String DescSully, Rating rating) {
		return new CatalogItem("R", "Sample Movie", 2.0);
	}
}
