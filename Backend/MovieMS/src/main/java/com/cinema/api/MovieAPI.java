package com.cinema.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.dto.MovieDTO;
import com.cinema.entity.Movie;
import com.cinema.exception.MovieException;
import com.cinema.repository.MovieRepository;
import com.cinema.service.MovieService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/movie")
public class MovieAPI {
	@Autowired
	private MovieService movieService;
	@Autowired
	private Environment environment;
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadNewMovie(@RequestBody @Valid MovieDTO movieDTO) throws MovieException{
		int movieId = movieService.uploadMovie(movieDTO);
		return new ResponseEntity<String>(environment.getProperty("API.MOVIE_UPLOADED_SUCCESSFULLY") + ": "+movieId, HttpStatus.CREATED);
	}
	
	@GetMapping("/getMovie/{movieId}")
	public ResponseEntity<MovieDTO> getMovie(@PathVariable Integer movieId) throws MovieException{
		MovieDTO movieDTO = movieService.getMovieById(movieId);
		return new ResponseEntity<>(movieDTO, HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllMovie")
	public ResponseEntity<Iterable<Movie>> getAllMovies(){
		return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.FOUND);
	}
	
	
	
}
