package com.LetterBoxD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LetterBoxD.interfaces.IMovieService;
import com.LetterBoxD.model.Movie;
import com.LetterBoxD.repository.MovieRepository;

@Service
public class MovieService implements IMovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	public Movie findById(long id) {
		if ((movieRepository.findById(id)).isEmpty())
			return null;
		return movieRepository.findById(id).get();
	}

	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	public Movie create(Movie Movie) {
		return movieRepository.save(Movie);
		// aggiungere logica FK per controllo
	}

	

	public Movie update(long id, Movie newMovie) {

		Optional<Movie> optMovie = movieRepository.findById(id);
		Movie oldMovie;

		if (optMovie.isEmpty())
			return null;

		else {
			oldMovie = optMovie.get();

			oldMovie.setTitle(newMovie.getTitle());
			oldMovie.setYear(newMovie.getYear());
			oldMovie.setLenght(newMovie.getLenght());
			oldMovie.setCountry(newMovie.getCountry());
			oldMovie.setDirector(newMovie.getDirector());
			oldMovie.setListMovie(newMovie.getListMovie());
			oldMovie.setActive(newMovie.isActive());
			
			
			movieRepository.save(oldMovie);
		}

		return oldMovie;
	}
	
	public boolean delete(long id) {

		Optional<Movie> movieOpt = movieRepository.findById(id);
		Movie oldMovie;

		if (movieOpt.isEmpty())
			return false;

		else {
			oldMovie = movieOpt.get();
			oldMovie.setActive(false);
			movieRepository.save(oldMovie);
			return true;
		}
	}

}
