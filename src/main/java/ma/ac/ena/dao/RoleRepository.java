package ma.ac.ena.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ena.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	public Role findByRole(String roleName);

}

// public interface RoleRepository extends JpaRepository<User, String>,
// MyRoleCustomRepository<User, String> {
// }
