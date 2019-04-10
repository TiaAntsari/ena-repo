package ma.ac.ena.services;

public interface RolesPermissionsForms {
	public void addPermissionOnFormsToRole(String role, String permission, String forms);

	public void removePermissionOnFormsToRole(String role, String permission, String forms);
}
