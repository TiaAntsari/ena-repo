package ma.ac.ena.services;

import java.util.List;

import ma.ac.ena.entities.Role;

public interface RoleService {
	public Role saveRole(Role r);

	public List<Role> findAllRoles();

	public Role findRoleByRoleName(String roleName);
}
