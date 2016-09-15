package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Role;
import io.egen.movieflix.repository.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repository;
	
	@Override
	public List<Role> addRole(List<Role> roles) {
		
		return repository.addRole(roles);
	}

	
	
}
