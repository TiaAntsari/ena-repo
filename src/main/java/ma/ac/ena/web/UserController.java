package ma.ac.ena.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.ena.entities.User;
import ma.ac.ena.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// @Secured(value = { "ROLE_ADMIN", "ROLE_SCOLARITE" })
	@RequestMapping(value = "/addUser")
	public User saveUser(User u) {
		return userService.save(u);
	}

	// @Secured(value = { "ROLE_ADMIN", "ROLE_SCOLARITE" })
	@RequestMapping(value = "/findUsers")
	public List<User> findUsers() {
		return userService.findAll();
	}

}
