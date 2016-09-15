package io.egen.movieflix.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity 
@SqlResultSetMapping(name="srsm" ,entities=@EntityResult(entityClass=Movie.class))
@Table 
@NamedQueries({
	@NamedQuery(name = "Movie.findMovieDetailsByTitle", query ="Select m from Movie m where m.title=:ptitle"),
	@NamedQuery(name = "Movie.filterMoviesByYear", query ="Select m from Movie m where m.year=:pyear"),
	@NamedQuery(name = "Movie.sortMoviesByImdbRatings", query ="Select m from Movie m where m.type='movie' order by m.imdbRatings desc"),
	@NamedQuery(name = "Movie.sortMoviesByYear", query ="Select m from Movie m Where m.type = 'movie' order by m.year desc"),
	@NamedQuery(name = "Movie.sortSeriesByYear", query ="Select m from Movie m Where m.type = 'series' order by m.year desc"),
	@NamedQuery(name = "Movie.sortMoviesByImdbVotes", query ="Select m from Movie m Where m.type = 'movie' order by m.imdbVotes desc"),
	@NamedQuery(name = "Movie.sortSeriesByImdbVotes", query ="Select m from Movie m Where m.type = 'series' order by m.imdbVotes desc"),
	@NamedQuery(name = "Movie.findTopRatedMovies", query ="Select m from Movie m Where m.type = 'movie' order by m.imdbRatings desc"),
	@NamedQuery(name = "Movie.findTopRatedSeries",query ="Select m from Movie m Where m.type = 'series'  order by m.imdbRatings desc"),
	@NamedQuery(name = "Movie.findMovies",query ="Select m from Movie m Where m.type = 'movie' "),
	@NamedQuery(name = "Movie.findSeries",query ="Select m from Movie m Where m.type = 'series' ")
})



public class Movie {
	
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	@Id
	private String movieId;
	
	private String year;
	
	private String language;
	 
	private String runtime;
	
	private String country;
	
	private String awards;
	
	private String poster;
	
	@Column(columnDefinition = "TEXT")
	private String plot;
	
	private String metascore;
	
	private float imdbRatings;
	
	private int imdbVotes;
	
	private String imdbId;
	
	private String title;
	
	private String type;
	
	private float flixRating;
	
	@ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
    @JoinTable(name="Movie_Genre",
        joinColumns = @JoinColumn(name="movieId"),
        inverseJoinColumns = @JoinColumn(name="genreId")
              )
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Genre> genres;
	
	@ManyToMany
	@JoinTable(name="Movie_Crew",
    joinColumns = @JoinColumn(name="movieId"),
    inverseJoinColumns = @JoinColumn(name="crewId")
          )
	@LazyCollection(LazyCollectionOption.FALSE)	
	private List<Crew> crew;
	
	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public float getImdbRatings() {
		return imdbRatings;
	}

	public void setImdbRatings(float imdbRatings) {
		this.imdbRatings = imdbRatings;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
//	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public float getFlixRating() {
		return flixRating;
	}

	public void setFlixRating(float flixRating) {
		this.flixRating = flixRating;
	}

	

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getMetascore() {
		return metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public List<Crew> getCrew() {
		return crew;
	}

	public void setCrew(List<Crew> crew) {
		this.crew = crew;
	}
	
        
        
	
	
	
	
}	
