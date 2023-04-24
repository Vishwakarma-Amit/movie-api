package com.amit.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.movie.entity.Movie;
import com.amit.movie.repository.MovieRepository;
import com.amit.movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> allMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie singleMovie(String imdbId) throws Exception {
		return movieRepository.findMovieByImdbId(imdbId).orElseThrow(()-> new Exception("Movie not found"));
	}

}
