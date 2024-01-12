package com.LetterBoxD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LetterBoxD.interfaces.IDirectorService;
import com.LetterBoxD.model.Director;
import com.LetterBoxD.repository.DirectorRepository;

@Service
public class DirectorService implements IDirectorService {

	@Autowired
	private DirectorRepository directorRepository;

	@Override
	public Director findById(long id) {
		if ((directorRepository.findById(id)).isEmpty())
			return null;
		return directorRepository.findById(id).get();
	}

	@Override
	public List<Director> findAll() {
		return directorRepository.findAll();
	}

	@Override
	public Director create(Director director) {
		return directorRepository.save(director);
		// aggiungere logica FK per controllo
	}

	@Override
	public Director update(long id, Director newDirector) {
		Optional<Director> optDirector = directorRepository.findById(id);
		Director oldDirector;

		if (optDirector.isEmpty())
			return null;

		else {
			oldDirector = optDirector.get();

			oldDirector.setName(newDirector.getName());
			oldDirector.setSurname(newDirector.getSurname());
			oldDirector.setCountry(newDirector.getCountry());
			oldDirector.setDob(newDirector.getDob());
			oldDirector.setActive(newDirector.isActive());

			directorRepository.save(oldDirector);
		}

		return oldDirector;
	}

	@Override
	public boolean delete(long id) {
		Optional<Director> optDirector = directorRepository.findById(id);
		Director oldDirector;

		if (optDirector.isEmpty())
			return false;

		else {
			oldDirector = optDirector.get();
			oldDirector.setActive(false);
			directorRepository.save(oldDirector);
			return true;
		}
	}

}
