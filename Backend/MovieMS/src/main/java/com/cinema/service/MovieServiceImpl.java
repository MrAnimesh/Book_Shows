package com.cinema.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.dto.MovieDTO;
import com.cinema.entity.Movie;
import com.cinema.exception.MovieException;
import com.cinema.repository.MovieRepository;

import jakarta.transaction.Transactional;

@Service(value = "movieService")
@Transactional
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public MovieDTO getMovieById(Integer movieId) throws MovieException{
		Optional<Movie> optionalMovie = movieRepository.findById(movieId);
		Movie movie = optionalMovie.orElseThrow(() -> new MovieException("Service.MOVIE_NOT_FOUND"));
		
		MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);
		return movieDTO;
		
	}
	
	public Integer uploadMovie(MovieDTO movieDTO) throws MovieException{
		Movie movie = modelMapper.map(movieDTO, Movie.class);
		return movieRepository.save(movie).getId();
	}
	

	
}
