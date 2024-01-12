package com.LetterBoxD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LetterBoxD.interfaces.IListMovieService;
import com.LetterBoxD.model.ListMovie;
import com.LetterBoxD.repository.ListMovieRepository;

@Service
public class ListMovieService implements IListMovieService {

	@Autowired
	private ListMovieRepository listMovieRepository;

	@Override
	public ListMovie findById(long id) {
		if ((listMovieRepository.findById(id)).isEmpty())
			return null;
		return listMovieRepository.findById(id).get();
	}

	@Override
	public List<ListMovie> findAll() {
		return listMovieRepository.findAll();
	}

	@Override
	public ListMovie create(ListMovie listMovie) {
		return listMovieRepository.save(listMovie);
		// aggiungere logica FK per controllo
	}

	@Override
	public ListMovie update(long id, ListMovie newListMovie) {
		Optional<ListMovie> optListMovie = listMovieRepository.findById(id);
		ListMovie oldListMovie;

		if (optListMovie.isEmpty())
			return null;

		else {
			oldListMovie = optListMovie.get();

			oldListMovie.setName(newListMovie.getName());
			oldListMovie.setDescription(newListMovie.getDescription());
			oldListMovie.setDoCreation(newListMovie.getDoCreation());
			oldListMovie.setUser(newListMovie.getUser());
			oldListMovie.setMovies(newListMovie.getMovies());
			oldListMovie.setActive(newListMovie.isActive());

			listMovieRepository.save(oldListMovie);
		}

		return oldListMovie;
	}

	@Override
	public boolean delete(long id) {
		Optional<ListMovie> optListMovie = listMovieRepository.findById(id);
		ListMovie oldListMovie;

		if (optListMovie.isEmpty())
			return false;

		else {
			oldListMovie = optListMovie.get();
			oldListMovie.setActive(false);
			listMovieRepository.save(oldListMovie);
			return true;
		}
	}

}
