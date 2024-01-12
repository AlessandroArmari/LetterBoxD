package com.LetterBoxD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LetterBoxD.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long > {

}
