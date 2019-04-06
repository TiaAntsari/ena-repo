package ma.ac.ena.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.ena.entities.User;
import ma.ac.ena.services.UserService;
import ma.ac.ena.services.UsersRolesService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UsersRolesService usersRolesService;

	// @Secured(value = { "ROLE_ADMIN", "ROLE_SCOLARITE" })
	@RequestMapping(value = "/addUser")
	public User saveUser(User u) {
		return userService.saveUser(u);
	}

	// @Secured(value = { "ROLE_ADMIN", "ROLE_SCOLARITE" })
	@RequestMapping(value = "/findUsers")
	public List<User> findUsers() {
		return userService.findAllUsers();
	}

	// A verifier (ne fonctionne pas encore. il faut verifier si username et role
	// sont dans la base)
	@RequestMapping(value = "/addRoleToUser")
	public void addRoleToUser(String username, String role) {
		usersRolesService.addRoleToUser(username, role);
	}

}
