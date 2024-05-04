package com.cinema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cinema.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer>{
	public List<Movie> findMovieById(Integer movieId);
}
