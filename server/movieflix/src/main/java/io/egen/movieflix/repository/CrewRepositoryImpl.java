package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Crew;
import io.egen.movieflix.entity.Role;
import io.egen.movieflix.service.RoleService;
@Repository
public class CrewRepositoryImpl implements CrewRepository {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private RoleService roleService;
	@Override
	public List<Crew> addCrew(List<Crew> crewList) {
		for(Crew crew: crewList){
			List<Role> roles = roleService.addRole(crew.getRoles());
			crew.setRoles(roles);
			em.persist(crew);
		}
		return crewList;
	}

}
