package ma.ac.ena.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.ena.entities.Role;
import ma.ac.ena.services.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Secured(value = { "ROLE_ADMIN", "ROLE_SCOLARITE" })
	@RequestMapping(value = "/addRole")
	public Role saveRole(Role r) {
		return roleService.save(r);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_SCOLARITE" })
	@RequestMapping(value = "/findRoles")
	public List<Role> findRoles() {
		return roleService.findAll();
	}
}
