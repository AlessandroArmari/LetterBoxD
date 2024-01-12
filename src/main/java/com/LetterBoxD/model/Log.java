package com.LetterBoxD.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="log")
public class Log {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDateTime doLog;
	
	@Column
	private double vote;
	
	@Column(length = 15000)
	private String review;
	
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "fk_movie_id")
	private Movie movie;
	
	@Column
	private boolean isActive;
	
	

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getDoLog() {
		return doLog;
	}

	public void setDoLog(LocalDateTime doLog) {
		this.doLog = doLog;
	}

	public double getVote() {
		return vote;
	}

	public void setVote(double vote) {
		this.vote = vote;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public long getId() {
		return id;
	}
	
	
	
	

}
