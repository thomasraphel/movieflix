package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.Role;

public interface RoleRepository {

	List<Role> addRole(List<Role> roles);

}
