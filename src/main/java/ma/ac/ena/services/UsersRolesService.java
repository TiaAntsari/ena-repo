package ma.ac.ena.services;

import java.util.Collection;

import ma.ac.ena.entities.Role;

public interface UsersRolesService {
	public void addRoleToUser(String username, String roleName);

	public Collection<Role> findRoleByUsername(String username);

	public void removeRoleToUser(String username, String roleName);

}
