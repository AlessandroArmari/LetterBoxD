package com.LetterBoxD.interfaces;

import java.util.List;

import com.LetterBoxD.model.Director;


public interface IDirectorService {

	public Director findById(long id);

	public List<Director> findAll();

	public Director create(Director director);

	public Director update(long id, Director newDirector);

	public boolean delete(long id);
}
