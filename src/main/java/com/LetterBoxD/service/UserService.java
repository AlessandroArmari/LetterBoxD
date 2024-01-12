package com.LetterBoxD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LetterBoxD.interfaces.IUserService;
import com.LetterBoxD.model.User;
import com.LetterBoxD.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findById(long id) {
		if ((userRepository.findById(id)).isEmpty())
			return null;
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(long id, User newUser) {
		Optional<User> optUser = userRepository.findById(id);
		User oldUser;

		if (optUser.isEmpty())
			return null;

		else {
			oldUser = optUser.get();

			oldUser.setUserName(newUser.getUserName());
			oldUser.setPassword(newUser.getPassword());
			oldUser.setDoSigning(newUser.getDoSigning());
			oldUser.setAdmin(newUser.isAdmin());
			oldUser.setActive(newUser.isActive());
			
			userRepository.save(oldUser);
		}

		return oldUser;
	}

	@Override
	public boolean delete(long id) {
		Optional<User> userOpt = userRepository.findById(id);
		User oldUser;

		if (userOpt.isEmpty())
		return false;

		else {
			oldUser = userOpt.get();
			oldUser.setActive(false);
			userRepository.save(oldUser);
			return true;
		}
	}

}
