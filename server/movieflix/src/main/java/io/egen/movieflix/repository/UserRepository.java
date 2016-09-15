package io.egen.movieflix.repository;

import io.egen.movieflix.entity.User;


public interface UserRepository {
	
	public User create(User user);

	User findByEmail(String email);

	public User login(User user);

	

	
	
	

}
