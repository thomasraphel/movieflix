package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Role;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Role> addRole(List<Role> roles) {
		for(Role role : roles)
			em.persist(role);
		return roles;
	}

}
