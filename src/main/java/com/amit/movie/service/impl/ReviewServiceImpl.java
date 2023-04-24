package com.amit.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.amit.movie.entity.Movie;
import com.amit.movie.entity.Review;
import com.amit.movie.repository.ReviewRepository;
import com.amit.movie.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Review createReview(String reviewBody, String imdbId) throws Exception {

		Review review = reviewRepository.insert(new Review(reviewBody));

		mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId))
				.apply(new Update().push("reviewIds", review)).first();

//		Movie movie = movieService.singleMovie(imdbId);
//		
//		List<Review> reviewIds = movie.getReviewIds();
//		reviewIds.add(review);
//		
//		movieRepository.save(movie);
		return review;
	}

}
