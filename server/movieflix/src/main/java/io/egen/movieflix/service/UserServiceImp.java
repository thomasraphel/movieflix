package io.egen.movieflix.service;



//import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.User;

import  io.egen.movieflix.repository.UserRepository;






@Service
public class UserServiceImp implements UserService {
	
	
	@Autowired
	UserRepository repository;
	
	

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if (existing != null) {
			return null;
		}
		
		return repository.create(user);
	}



	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return repository.login(user);
	}
	

	
	
}
