package io.javabrains.movieInfoservice.resrouce;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieInfoservice.model.Moive;

@RestController
@RequestMapping("/movies")
public class MoiveResource {
	
	@RequestMapping("/{moiveId}")
	public Moive getMovieInfo(@PathVariable("moiveId") String movieId) {
	return new Moive(movieId,"Test Name");	
	}

}
