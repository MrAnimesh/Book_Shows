package com.cinema.service;

import com.cinema.dto.MovieDTO;
import com.cinema.exception.MovieException;

public interface MovieService {
	public MovieDTO getMovieById(Integer movieId) throws MovieException;
	public Integer uploadMovie(MovieDTO movieDTO) throws MovieException;

}
