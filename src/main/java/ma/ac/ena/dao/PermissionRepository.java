package ma.ac.ena.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ena.entities.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
	public Permission findByOperation(String operation);
}
