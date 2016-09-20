package io.egen.movieflix.entity;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;




@NamedQueries({
	
	//@NamedQuery(name = "User.insertUser", query = "SELECT u FROM User u WHERE u.email=:pEmail"),
	@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email=:pEmail")
})

@Entity
@Table 
public class User {

	

	
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	@Id
	private String userId;
	
	private String password;
	
	private String firstName;
	private String lastName;
	private String userRole;

	@Column(unique = true)
	private String email;
	
	
	
	
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	

	

	
}

