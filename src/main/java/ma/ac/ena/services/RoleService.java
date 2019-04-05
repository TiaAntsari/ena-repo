package ma.ac.ena.services;

import java.util.List;

import ma.ac.ena.entities.Role;

public interface RoleService {
	Role save(Role r);

	List<Role> findAll();
}
