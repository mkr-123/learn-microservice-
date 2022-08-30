package io.javabrains.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Moive;
import io.javabrains.moviecatalogservice.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")  String userId){
		//get all rated movieId
		RestTemplate restTemplate=new RestTemplate();
		
		List<Rating>  ratings=Arrays.asList(
				new Rating("1234", 4),
				new Rating("5678", 3)
				);
		
		return ratings.stream().map(rating ->{ 
		Moive moive=  restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(),Moive.class);
		return new CatalogItem(moive.getName(),"desc",rating.getRating());
		}).collect(Collectors.toList());
		
	
		
		//For each movieId ,call movie info service and get details
		//put them all together
	//return Collections.singletonList(new CatalogItem("K2","super",5));	
	}
}
