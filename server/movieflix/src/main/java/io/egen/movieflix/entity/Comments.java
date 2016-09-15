package io.egen.movieflix.entity;





import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;






@Entity
@Table
@NamedQueries({
	//@NamedQuery(name = "Type.findSeries", query ="Select t from Type t join t.Movie m where  t.type='series' order by m.imdbRatings "),
	//@NamedQuery(name = "Type.findMovies", query ="Select t from Type t where t.type='movie' "),
	
	
})
public class Comments {
	
	@Id
	private String commentId;
	
	private String comment;
	
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
	@JoinColumn(name="movieId") 
	private Movie movie;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
	@JoinColumn(name="userId")
	private User user;

	
	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	
	
	
	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	

	
	
	

}
