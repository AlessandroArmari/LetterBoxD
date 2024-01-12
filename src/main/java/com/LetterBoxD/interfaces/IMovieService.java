package com.LetterBoxD.interfaces;

import java.util.List;

import com.LetterBoxD.model.Movie;

public interface IMovieService  {
	
	public Movie findById(long id);
	
	public List<Movie> findAll();
	
	public Movie create(Movie Movie);
	
	public Movie update(long id, Movie newMovie);
	
	public boolean delete(long id);
}
