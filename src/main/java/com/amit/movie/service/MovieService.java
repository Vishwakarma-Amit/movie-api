package com.amit.movie.service;

import java.util.List;

import com.amit.movie.entity.Movie;

public interface MovieService {

	List<Movie> allMovies();

	Movie singleMovie(String imdbId) throws Exception;
}
