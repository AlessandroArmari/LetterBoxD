package com.LetterBoxD;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.LetterBoxD.interfaces.IDirectorService;
import com.LetterBoxD.interfaces.IListMovieService;
import com.LetterBoxD.interfaces.ILogService;
import com.LetterBoxD.interfaces.IMovieService;
import com.LetterBoxD.interfaces.IUserService;
import com.LetterBoxD.model.Director;
import com.LetterBoxD.model.ListMovie;
import com.LetterBoxD.model.Log;
import com.LetterBoxD.model.Movie;
import com.LetterBoxD.model.User;

//use to upload DB lines
@Component
public class DataLoadRunner implements CommandLineRunner {

	@Autowired
	private IDirectorService iDirectorService;

	@Autowired
	private IMovieService iMovieService;

	@Autowired
	private IUserService iUserService;

	@Autowired
	private IListMovieService iListMovieService;

	@Autowired
	private ILogService iLogService;

	@Override
	public void run(String... args) throws Exception {

		// Tarantino
		Director tarantino = new Director();
		tarantino.setName("Quentin");
		tarantino.setSurname("Tarantino");
		tarantino.setCountry("USA");
		tarantino.setDob(LocalDate.of(1962, 03, 03));
		tarantino.setActive(true);
		iDirectorService.create(tarantino);

		// Friedkin
		Director friedkin = new Director();
		friedkin.setName("Friedkin");
		friedkin.setSurname("William");
		friedkin.setCountry("USA");
		friedkin.setDob(LocalDate.of(1935, 8, 29));
		friedkin.setActive(true);
		iDirectorService.create(friedkin);

		// Pulp Fiction
		Movie pulpFiction = new Movie();
		pulpFiction.setTitle("Pulp Fiction");
		pulpFiction.setYear(1994);
		pulpFiction.setLenght(154);
		pulpFiction.setCountry("USA");
		pulpFiction.setDirector(tarantino);
		pulpFiction.setActive(true);
		iMovieService.create(pulpFiction);

		// exorcist
		Movie exorcist = new Movie();
		exorcist.setTitle("The Exorcist");
		exorcist.setYear(1973);
		exorcist.setLenght(122);
		exorcist.setCountry("USA");
		exorcist.setDirector(friedkin);
		exorcist.setActive(true);
		iMovieService.create(exorcist);

		// Django Unchained
		Movie django = new Movie();
		django.setTitle("Django Unchained");
		django.setYear(2012);
		django.setLenght(165);
		django.setCountry("USA");
		django.setDirector(tarantino);
		django.setActive(true);
		iMovieService.create(django);

		// French Connection
		Movie frenchConnection = new Movie();
		frenchConnection.setTitle("French Connection");
		frenchConnection.setYear(1972);
		frenchConnection.setLenght(104);
		frenchConnection.setCountry("USA");
		frenchConnection.setDirector(friedkin);
		frenchConnection.setActive(true);
		iMovieService.create(frenchConnection);

		// user alex91
		User alex91 = new User();
		alex91.setUserName("alex91");
		alex91.setPassword("6666");
		alex91.setDoSigning(LocalDateTime.of(2023, 4, 24, 21, 30));
		alex91.setAdmin(false);
		alex91.setActive(true);
		iUserService.create(alex91);

		// listMovie alex91Favourite
		ListMovie alex91Favourite = new ListMovie();
		alex91Favourite.setName("alex91Favourite");
		alex91Favourite.setDescription("My favourite movies!!!");
		alex91Favourite.setDoCreation(LocalDateTime.of(2023, 4, 26, 12, 45, 13));
		alex91Favourite.setUser(alex91);
		List<Movie> alex91FavouriteList = new ArrayList<Movie>(Arrays.asList(pulpFiction, exorcist));
		alex91Favourite.setMovies(alex91FavouriteList);
		alex91Favourite.setActive(true);
		iListMovieService.create(alex91Favourite);
		
		//log 1
		Log log1 = new Log();
		log1.setVote(4.5);
		log1.setReview("Best movie I've ever seen. Chasing sequence AAA+++");
		log1.setDoLog(LocalDateTime.of(2023, 4, 27, 15, 34, 22));
		log1.setUser(alex91);
		log1.setMovie(frenchConnection);
		log1.setActive(true);
		iLogService.create(log1);
		
		//log 2
		Log log2 = new Log();
		log2.setVote(3.5);
		log2.setReview("It's a good movie! Not a Tarantino's good movie!");
		log2.setDoLog(LocalDateTime.of(2023, 4, 28, 23, 54, 56));
		log2.setUser(alex91);
		log2.setMovie(django);
		log2.setActive(true);
		iLogService.create(log2);
	}
}
