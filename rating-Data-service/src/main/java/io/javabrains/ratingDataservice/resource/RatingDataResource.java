package io.javabrains.ratingDataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingDataservice.model.Rating;
import io.javabrains.ratingDataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

    @RequestMapping("/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }
    
    @RequestMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable("userId") String userId) {
    	List<Rating>  ratings=Arrays.asList(
				new Rating("1234", 4),
				new Rating("5678", 3)
				);
    	UserRating userRating=new UserRating();
    	userRating.setUserRatingList(ratings);
    	
    	return userRating;
    }

}