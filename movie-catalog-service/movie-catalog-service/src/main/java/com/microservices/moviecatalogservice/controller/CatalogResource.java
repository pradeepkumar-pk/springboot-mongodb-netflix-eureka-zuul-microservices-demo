package com.microservices.moviecatalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.moviecatalogservice.models.Movie;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String message() {
		return "welcome to MovieCatalog..!";
	}
	
	@GetMapping("/getAllMovies")
	public Movie[] getCat() {
		Movie[] movie = restTemplate.getForObject("http://localhost:8082/getAllMovies/", Movie[].class);
//		System.out.println(movie.getMovieId());
//		System.out.println(movie.getName());
//		System.out.println(movie.getDescription());
		return movie;
	}
	
//	@GetMapping("/{userId}")
//	public Movie getCatalog(@PathVariable String userId) {
//		Movie movie = restTemplate.getForObject("http://localhost:8082/getMovie/" + userId, Movie.class);
//		System.out.println(movie.getMovieId());
//		System.out.println(movie.getName());
//		System.out.println(movie.getDescription());
//		return movie;
//		
//	}
	

}
