package ma.ac.ena.services;

import java.util.List;

import ma.ac.ena.entities.Role;

public interface RoleService {
	public Role saveRole(Role r);

	public void deleteRoleByRoleName(String roleName);

	public void deleteRoleByIdRole(int idRole);

	public List<Role> findAllRoles();

	public Role findRoleByRoleName(String roleName);
}
