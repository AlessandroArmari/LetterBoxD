package com.LetterBoxD.interfaces;

import java.util.List;

import com.LetterBoxD.model.ListMovie;

public interface IListMovieService {
	
	public ListMovie findById(long id);

	public List<ListMovie> findAll();

	public ListMovie create(ListMovie listMovie);

	public ListMovie update(long id, ListMovie newListMovie);

	public boolean delete(long id);

}
