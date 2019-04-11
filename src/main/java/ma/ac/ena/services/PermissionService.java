package ma.ac.ena.services;

import java.util.List;

import ma.ac.ena.entities.Permission;

public interface PermissionService {
	public Permission savePermission(Permission permission);

	public void deletePermissionByOperation(String operation);

	public void deletePermissionByIdPermission(int idPermission);

	public List<Permission> findAllPermissions();

	public Permission findPermissionByOperation(String operation);

	public Permission findPermissionByIdPermission(int idPermission);
}
