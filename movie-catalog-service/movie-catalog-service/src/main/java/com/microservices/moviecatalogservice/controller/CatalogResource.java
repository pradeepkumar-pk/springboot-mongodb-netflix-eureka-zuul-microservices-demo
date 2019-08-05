package com.microservices.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.moviecatalogservice.models.CatalogItem;
import com.microservices.moviecatalogservice.models.Movie;
import com.microservices.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String message() {
		return "welcome to MovieCatalog..!";
	}
	
	@GetMapping("/getAllMoviesRatings")
	public UserRating[] getRat() {
		UserRating[] userRating = restTemplate.getForObject("http://localhost:8083/getAllMoviesRatings/", UserRating[].class);
		return userRating;
	}
	
	@GetMapping("/getAllMoviesInfo")
	public Movie[] getCat() {
		Movie[] movie = restTemplate.getForObject("http://localhost:8082/getAllMoviesInfo/", Movie[].class);
		return movie;
	}
	
	@GetMapping("/getMovieInfo/{movieId}")
	public Movie getCatalog(@PathVariable String movieId) {
		Movie movie = restTemplate.getForObject("http://localhost:8082/getMovieInfo/" + movieId, Movie.class);
		System.out.println(movie.getMovieId());
		System.out.println(movie.getName());
		System.out.println(movie.getDescription());
		return movie;
		
	}
	
	@GetMapping("/getMovieRating/{userId}")
	public UserRating getRating(@PathVariable String userId) {
		UserRating userRating = restTemplate.getForObject("http://localhost:8083/getMovieRating/" + userId, UserRating.class);
//		System.out.println(movie.getMovieId());
//		System.out.println(movie.getName());
//		System.out.println(movie.getDescription());
		return userRating;
		
	}
	
	@GetMapping("/{userId}")
    public List<CatalogItem> getFullCatalog(@PathVariable String userId) {
			System.out.println("---------------------- inside catalog 1 ----------------------");
        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/getMovieRating/" + userId, UserRating.class);
        	System.out.println("---------------------- inside catalog 2 ----------------------");
        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/getMovieInfo/" + rating.getMovieId(), Movie.class);
                    	System.out.println("---------------------- inside catalog 3 ----------------------");
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());
    }
	

}
