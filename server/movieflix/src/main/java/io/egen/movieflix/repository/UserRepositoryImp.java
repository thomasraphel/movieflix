package io.egen.movieflix.repository;



//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import io.egen.movieflix.entity.User;


import org.springframework.stereotype.Repository;




@Repository
public class UserRepositoryImp implements UserRepository {
	
	
	@PersistenceContext
	public EntityManager em;

	
	@Override
	public User create(User user) {
		
		em.merge(user);
		return user;
	}
	
	
	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		User existing = query.getSingleResult();
		if (existing != null ) {
			return existing;
		}
		return null;
	}


	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", user.getEmail());
		User existing = query.getSingleResult();
		if (existing != null && existing.getPassword().equals(user.getPassword())) {
			
				return user;
			}
		
		return null;
	}

	
	
	

}
