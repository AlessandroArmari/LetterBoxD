package com.LetterBoxD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LetterBoxD.model.ListMovie;

@Repository
public interface ListMovieRepository extends JpaRepository<ListMovie, Long > {

}
