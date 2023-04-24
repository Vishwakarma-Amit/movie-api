package com.amit.movie.service;

import com.amit.movie.entity.Review;

public interface ReviewService {
	
	Review createReview(String reviewBody, String imdbId) throws Exception;
	

}
