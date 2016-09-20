package io.egen.movieflix.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.service.MovieService;





@RestController
@RequestMapping(path = "videos")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	
	//adding a new video to database....DONEDONE
	@RequestMapping(method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie add(@RequestBody Movie movie) {
		return service.add(movie);
	}
	
	//find movie details by title ......DONEDONE
	@RequestMapping(method = RequestMethod.GET,path="/movie/{movie_name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findMovieDetails(@PathVariable("movie_name") String name) {
		return service.findMovieDetails(name);
	}
	
	
	
	//top rated movies by imdb ratings......DONEDONE
	@RequestMapping(method = RequestMethod.GET,path="/movie/toprated", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findTopRatedMovies() {
		return service.findTopRatedMovies();
	}
	
	//find all movies......DONEDONE
	@RequestMapping(method = RequestMethod.GET,path="/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findMovies() {
		return service.findMovies();
	}
	
	
	//find all series......DONEDONE
		@RequestMapping(method = RequestMethod.GET,path="/series", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> findSeries() {
			return service.findSeries();
		}
	
	
	//top rated series by imdb ratings .....DONEDONE
	@RequestMapping(method = RequestMethod.GET,path="/series/toprated", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findTopRatedSeries() {
		return service.findTopRatedSeries();
	}
	
	
	//filter movies by year......DONEDONE
	@RequestMapping(method = RequestMethod.GET,path="/movie/year/{year}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> filterMoviesByYear(@PathVariable("year") String year) {
		return service.filterMoviesByYear(year);
	}
	
	//filter movies by genre parameterized.............DONEDONE   ....check the query in Genre class
		@RequestMapping(method = RequestMethod.GET,path="/movie/genre/{pgenre}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> filterMoviesByGenre(@PathVariable("pgenre") String genre) {
			return service.filterMoviesByGenre(genre);
		}
		
		
	//filter series by genre parameterized...........DONEDONE
		@RequestMapping(method = RequestMethod.GET,path="/series/genre/{pgenre}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> filterSeriesByGenre(@PathVariable("pgenre") String genre) {
			return service.filterSeriesByGenre(genre);
		}	
	
	
		
	//sort movies by imdbratings........DONEDONE
		@RequestMapping(method = RequestMethod.GET,path="/movie/sortbyimdbratings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortMovieByImdbRatings() {
			return service.sortMovieByImdbRatings();
		}
		
	//sort series by imdbratings......DONEDONE
		@RequestMapping(method = RequestMethod.GET,path="/series/sortbyimdbratings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortSeriesByImdbRatings() {
			return service.sortSeriesByImdbRatings();
		}
		
		
	//sort movies by year......DONEDONE
		@RequestMapping(method = RequestMethod.GET,path="/movie/sortbyyear", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortMovieByYear() {
			return service.sortMovieByYear();
		}
		
	//sort series by year.......DONEDONE
		@RequestMapping(method = RequestMethod.GET,path="/series/sortbyyear", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortSeriesByYear() {
			return service.sortSeriesByYear();
		}
		
		
	//sort movies by imdb votes...........DONEDONE
		@RequestMapping(method = RequestMethod.GET,path="/movie/sortbyimdbvotes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortMoviesByvotes() {
			return service.sortMoviesByvotes();
		}
		
		
		//sort series by imdb votes........DONEDONE
				@RequestMapping(method = RequestMethod.GET,path="/series/sortbyimdbvotes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
				public List<Movie> sortSeriesByvotes() {
					return service.sortSeriesByvotes();
				}	
		
		
			
		
	
	

	
	
	
	
	
	
	
	
	

}
