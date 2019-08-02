package com.microservices.movieinfoservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.movieinfoservice.model.Movie;
import com.microservices.movieinfoservice.repository.MovieRepository;

@RestController
public class MovieResource {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping("/")
	public String message() {
		return "welcome to MovieInfo..!";
	}
	
	@PostMapping("/addMovie")
	public Movie saveMovie(@RequestBody Movie movie) {
		System.out.println(movie.getMovieId());
		System.out.println(movie.getName());
		System.out.println(movie.getDescription());
		movieRepository.insert(movie);
		return movie;
	}
	
	@GetMapping("/getAllMovies")
	public Movie getMovies() {
		return (Movie) movieRepository.findAll();
	}

	@GetMapping("/getMovie/{id}")
	public Optional<Movie> getMovie(@PathVariable String id) {
		return movieRepository.findById(id);
	}


}
