package com.microservices.moviedataservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.moviedataservice.model.UserRating;

public interface RatingsRepository extends MongoRepository<UserRating, String> {

}
