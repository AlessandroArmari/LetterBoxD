package com.LetterBoxD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LetterBoxD.model.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long > {

}

