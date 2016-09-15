package io.egen.movieflix.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.repository.MovieRepository;




@Service
@Transactional
public class MovieServiceImp implements MovieService{
	
	
	@Autowired
	MovieRepository repository;
	
	
	
	
	

	@Override
	public List<Movie> findTopRatedMovies() {
		// TODO Auto-generated method stub
		return repository.findTopRatedMovies();
	}

	@Override
	public List<Movie> findTopRatedSeries() {
		// TODO Auto-generated method stub
		return repository.findTopRatedSeries();
	}

	@Override
	public List<Movie> filterMoviesByYear(String year) {
		// TODO Auto-generated method stub
		return repository.filterMoviesByYear(year);
	}

	@Override
	public List<Movie> filterMoviesByGenre(String g) {
		// TODO Auto-generated method stub
		return repository.filterMoviesByGenre(g);
	}

	@Override
	public List<Movie> filterSeriesByGenre(String g) {
		// TODO Auto-generated method stub
		return repository.filterSeriesByGenre(g);
	}

	@Override
	public List<Movie> sortSeriesByImdbRatings() {
		
		return repository.sortSeriesByImdbRatings();
	}

	@Override
	public List<Movie> sortMovieByYear() {
		
		return repository.sortMovieByYear();
	}

	@Override
	public List<Movie> sortSeriesByYear() {
		// TODO Auto-generated method stub
		return repository.sortSeriesByYear();
	}

	@Override
	public List<Movie> sortSeriesByvotes() {
		
		return repository.sortSeriesByvotes();
	}

	@Override
	public List<Movie> sortMoviesByvotes() {
		
		return repository.sortMoviesByvotes();
	}

	@Override
	public List<Movie> sortMovieByImdbRatings() {
		
		return repository.sortMovieByImdbRatings();
	}

	@Override
	public Movie findMovieDetails(String name) {
		
		return repository.findMovieDetails(name);
	}
	

	@Override
	public List<Movie> findMovies() {
		// TODO Auto-generated method stub
		return repository.findMovies();
	}

	@Override
	public List<Movie> findSeries() {
		// TODO Auto-generated method stub
		return repository.findSeries();
	}

	@Override
	public Movie add(Movie movie) {
		
		return repository.add(movie);
	}
	

}
