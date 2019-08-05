package com.microservices.moviedataservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.moviedataservice.model.UserRating;
import com.microservices.moviedataservice.repository.RatingsRepository;

@RestController
//@RequestMapping("/ratings")
public class RatingsResource {

	@Autowired
	private RatingsRepository ratingsRepository;
	
	@GetMapping("/")
	public String message() {
		return "welcome to MovieRatings..!";
	}
	
	@PostMapping("/addUserRating")
	public UserRating saveMovieRatings(@RequestBody UserRating userRating) {
		
//		final Address address = new Address("19 Imaginary Road", "Imaginary Place", "Imaginary City", "UK");
//		final Hobby badminton = new Hobby("Badminton");
//		final Hobby tv = new Hobby("TV");
//	    final List<Hobby> hobbies = Arrays.asList(badminton, tv);
//	    final Person john = new Person("John", "Doe", LocalDateTime.now(), address, "Winner", 100, hobbies);
		
//		final Rating rat1 = new Rating("5d44010614aa9b3e8cc852d8" , 4);
//		final Rating rat2 = new Rating("5d44014614aa9b3e8cc852d9" , 3);
//		final List<Rating> ratingss = Arrays.asList(rat1, rat2);
//		final UserRating ur = new UserRating("100", ratingss);
//		
//		System.out.println(ur.getUserId());
//		System.out.println(ur.getRatings().get(0).getMovieId());
//		System.out.println(ur.getRatings().get(0).getRating());
		
		System.out.println(userRating.getUserId());
		System.out.println(userRating.getRatings().get(0).getMovieId());
		System.out.println(userRating.getRatings().get(0).getRating());
		
		ratingsRepository.save(userRating);		
		return userRating;
		
		
	}
	
	@GetMapping("/getAllMoviesRatings")
	public List<UserRating> getMoviesRatings() {
		return ratingsRepository.findAll();
	}
	
	@GetMapping("/getMovieRating/{userId}")
	public Optional<UserRating> getMovieRating(@PathVariable String userId) {
			System.out.println("---------------------- inside rating 1 ----------------------");
		return ratingsRepository.findById(userId);
	}

}
