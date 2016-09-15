package io.egen.movieflix.repository;

import io.egen.movieflix.entity.Movie;

import java.util.List;

public interface MovieRepository {
	
	
	List<Movie> findTopRatedMovies();

	List<Movie> findTopRatedSeries();

	List<Movie> filterMoviesByYear(String y);

	List<Movie> filterMoviesByGenre(String g);

	List<Movie> filterSeriesByGenre(String g);

	List<Movie> sortSeriesByImdbRatings();

	List<Movie> sortMovieByYear();

	List<Movie> sortSeriesByYear();

	List<Movie> sortSeriesByvotes();

	List<Movie> sortMoviesByvotes();

	List<Movie> sortMovieByImdbRatings();

	Movie findMovieDetails(String name);

	List<Movie> findMovies();

	List<Movie> findSeries();

	Movie add(Movie movie);

}
