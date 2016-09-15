package io.egen.movieflix.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@SqlResultSetMapping(name="srsm2" ,entities=@EntityResult(entityClass=Crew.class))
public class Crew {

	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	@Id
	private String crewId;
	
	private String name;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="Movie_Crew",
	        joinColumns = @JoinColumn(name="crewId"),
	        inverseJoinColumns = @JoinColumn(name="movieId")
	              )
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Movie> movies;
	
	
	@ManyToMany
	@JoinTable(name="Crew_Role",
	        joinColumns = @JoinColumn(name="crewId"),
	        inverseJoinColumns = @JoinColumn(name="roleId")
	              )
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Role> roles;
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public String getCrewId() {
		return crewId;
	}
	public void setCrewId(String crewId) {
		this.crewId = crewId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
