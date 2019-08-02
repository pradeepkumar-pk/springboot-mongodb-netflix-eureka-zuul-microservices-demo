package com.microservices.movieinfoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.movieinfoservice.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {

}
