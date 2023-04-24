package com.amit.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.movie.entity.Movie;
import com.amit.movie.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies() {
		return new ResponseEntity<> (movieService.allMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/{imdbId}")
	public ResponseEntity<Movie> getSingleMovie(@PathVariable String imdbId) throws Exception {
		return new ResponseEntity<> (movieService.singleMovie(imdbId), HttpStatus.OK);
	}
}
