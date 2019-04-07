package ma.ac.ena.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.ena.entities.RegisterForm;
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
	// @PostMapping("/register")
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public User saveUser(@RequestBody RegisterForm registerForm) {
		if (!registerForm.getPassword().equals(registerForm.getRepassword())) {
			throw new RuntimeException("Entrez le meme mot de passe pour confirmer");
		}
		User user = userService.findUserByUsername(registerForm.getUsername());
		if (user != null) {
			throw new RuntimeException("Ce nom d'utilisateur existe déjà");
		}
		User u = new User();
		u.setUsername(registerForm.getUsername());
		u.setPassword(registerForm.getPassword());
		userService.saveUser(u);
		usersRolesService.addRoleToUser(registerForm.getUsername(), "USER");
		return u;
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
