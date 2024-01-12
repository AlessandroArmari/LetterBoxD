package com.LetterBoxD.interfaces;

import java.util.List;

import com.LetterBoxD.model.User;

public interface IUserService {

	public User findById(long id);

	public List<User> findAll();

	public User create(User user);

	public User update(long id, User newUser);

	public boolean delete(long id);
}
