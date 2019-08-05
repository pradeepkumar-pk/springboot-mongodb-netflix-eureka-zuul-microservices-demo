package com.microservices.moviedataservice.model;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EntityScan
@Document(collection = "MovieData")
public class UserRating {

	@Id
    private String userId;
	
	private List<Rating> ratings;
	
	
	 public UserRating(String userId, List<Rating> ratings) {
			this.userId = userId;
			this.ratings = ratings;
		}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

}
