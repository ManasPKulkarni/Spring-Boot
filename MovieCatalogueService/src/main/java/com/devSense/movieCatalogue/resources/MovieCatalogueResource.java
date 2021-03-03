package com.devSense.movieCatalogue.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.devSense.movieCatalogue.models.CatalogItem;
import com.devSense.movieCatalogue.models.Movie;
import com.devSense.movieCatalogue.models.Rating;
import com.devSense.movieCatalogue.models.UserRatings;
import com.devSense.movieCatalogue.service.MovieInfo;
import com.devSense.movieCatalogue.service.UserRatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogueResource {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingService userRatingServ;
	
//	@Autowired
//	private WebClient.Builder webClientBuilder;
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		String descMen = "The story ultimately revolves around two \"men of honor\"; their relationship, their individual and joint failures and triumphs. Carl Brashear is determined to be the first African American Navy Diver in a time where racism is rife. Leslie Sunday is his embittered trainer, determined to see him fail. Fate, challenges and circumstances eventually draw these two men together in a tale of turbulence and ultimately triumph.";
		String DescSully = "On Thursday, January 15, 2009, the world witnessed the \"Miracle on the Hudson\" when pilot Chesley\"Sully\" Sullenberger (Tom Hanks) glided his disabled plane onto the frigid waters of the Hudson River, saving the lives of all one hundred fifty-five aboard. However, even as Sully was being heralded by the public and the media for his unprecedented feat of aviation skill, an investigation was unfolding that threatened to destroy his reputation and his career";
			
		//get all movie Ids rated by a perticular user
			//hardcoding the ratings and movie ids
//		List<Rating> ratings = Arrays.asList(
//				new Rating("Men Of Honor", 7.9),
//				new Rating("Sully", 7.1)
//				);
		
		/*One way is to used parameterized type references
		ParameterizedTypeReference<List<Rating>>(){
			
		}*/
		

		UserRatings ratings = userRatingServ.getUserRating(userId);
		
		
		
//		RestTemplate restTemplate = new RestTemplate();
//		Movie movie = restTemplate.getForObject("localhost:8082/movies/movieId", Movie.class);
		
//		return ratings.stream().map(rating -> new CatalogItem("Men Of Honor", descMen, 7.2))
//		.collect(Collectors.toList());
		
		return ratings.getUserRating().stream().map(rating -> {
			return movieInfo.getCatlogItem(DescSully, rating);
		
			/*Movie movie = webClientBuilder.build()
			.get()
			.uri("http://localhost:8082/movies/" + rating.getMovieId())
			.retrieve()
			.bodyToMono(Movie.class)
			.block();
			*/
		})
		.collect(Collectors.toList());
		
		
	}


}
