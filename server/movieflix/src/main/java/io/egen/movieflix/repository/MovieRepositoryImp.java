package io.egen.movieflix.repository;



import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import io.egen.movieflix.entity.Crew;
import io.egen.movieflix.entity.Genre;
import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.service.CrewService;
import io.egen.movieflix.service.GenreService;


@Repository
public class MovieRepositoryImp implements MovieRepository {
	
	
	@PersistenceContext
	public EntityManager em;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private CrewService crewService;
	

	
	
	@Override
	public List<Movie> findTopRatedMovies() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopRatedMovies", Movie.class);
		return query.getResultList();
	}
	

	@Override
	public List<Movie> findTopRatedSeries() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopRatedSeries", Movie.class);
		return query.getResultList();
		
	}
	

	@Override
	public List<Movie> filterMoviesByYear(String year) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterMoviesByYear", Movie.class);
		query.setParameter("pyear", year);
		return query.getResultList();
	}
	
	
	

	@Override
	public List<Movie> filterMoviesByGenre(String genre) {
		
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findSpecificGenreMovies", Genre.class);
		query.setParameter("pgenre", genre);
		Genre movieGenre = query.getResultList().get(0);
		return movieGenre.getMovies();
	}
	
	
	
	

	@Override
	public List<Movie> filterSeriesByGenre(String genre) {
		
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findSpecificGenreSeries", Genre.class);
		query.setParameter("pgenre", genre);
		
		Genre movieGenre = query.getResultList().get(0);
		
		return movieGenre.getMovies();
	}

	@Override
	public List<Movie> sortSeriesByImdbRatings() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopRatedSeries", Movie.class);
		
		return query.getResultList();
		
	}

	@Override
	public List<Movie> sortMovieByYear() { 
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortMoviesByYear", Movie.class);
		
		return query.getResultList();
	}

	@Override
	public List<Movie> sortSeriesByYear() {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortSeriesByYear", Movie.class);
		
		return query.getResultList();
	}

	@Override
	public List<Movie> sortSeriesByvotes() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortSeriesByImdbVotes", Movie.class);
		
		return query.getResultList();
	}

	@Override
	public List<Movie> sortMoviesByvotes() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortMoviesByImdbVotes", Movie.class);
		
		return query.getResultList();
	}

	@Override
	public List<Movie> sortMovieByImdbRatings() {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopRatedMovies", Movie.class);
		
		return query.getResultList();
	}


	@Override
	public Movie findMovieDetails(String name) {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findMovieDetailsByTitle", Movie.class);
		query.setParameter("ptitle", name);
		Movie movie = query.getResultList().get(0);
		return movie;
	
	}


	@Override
	public List<Movie> findMovies() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findMovies", Movie.class);
		
		List<Movie> movies=query.getResultList();
		return movies;
		
	}


	@Override
	public List<Movie> findSeries() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findSeries", Movie.class);
		
		List<Movie> movies=query.getResultList();
		return movies;
		
	}


	@Override
	public Movie add(Movie movie) {
		List<Genre> genres = genreService.addGenre(movie.getGenres());
		List<Crew> crewList = crewService.addCrew(movie.getCrew());
		movie.setGenres(genres);
		movie.setCrew(crewList);
		em.persist(movie);
		return movie;
	}

}
