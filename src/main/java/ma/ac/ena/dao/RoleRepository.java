package ma.ac.ena.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ena.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByRole(String roleName);

	public Role findByIdRole(int idRole);

}
