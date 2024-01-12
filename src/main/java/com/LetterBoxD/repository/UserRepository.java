package com.LetterBoxD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LetterBoxD.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {

}
