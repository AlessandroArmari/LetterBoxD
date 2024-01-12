package com.LetterBoxD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LetterBoxD.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long > {

}
