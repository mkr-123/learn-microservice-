package io.javabrains.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Moive;
import io.javabrains.moviecatalogservice.model.Rating;
import io.javabrains.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")  String userId){
		//get all rated movieId
		
		
		UserRating  ratings=restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId, UserRating.class	);
		
		return ratings.getUserRatingList(). stream().map(rating ->{ 
			//For each movieId ,call movie info service and get details
		Moive moive=  restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),Moive.class);
		//put them all together
		return new CatalogItem(moive.getName(),"desc",rating.getRating());
		}).collect(Collectors.toList());
	//return Collections.singletonList(new CatalogItem("K2","super",5));	
	}
}
