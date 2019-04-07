package ma.ac.ena.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	// Confirmation For changing password and username by user
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

	@GetMapping("/resource")
	public User getLogedUser1(HttpSession session) {
		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();

		User user = new User();
		user = userService.findUserByUsername(username);
		// List<String> roles = new ArrayList<>();
		// for (GrantedAuthority ga :
		// securityContext.getAuthentication().getAuthorities()) {
		//
		// roles.add(ga.getAuthority());
		// }
		// Map<String, Object> params = new HashMap<>();
		// params.put("username", username);
		// params.put("roles", roles);

		// UserDetails userDetails = (UserDetails) auth.getPrincipal();
		// userDetails.getUsername();
		// userDetails.getAuthorities();
		// userDetails.getPassword();

		return user;
	}

	@RequestMapping("/test")
	public UserDetails getDashboard(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		return userDetails;
	}

	@GetMapping("/getLogedUser")
	public Map<String, Object> getLogedUser(HttpSession session) {
		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();

		List<String> roles = new ArrayList<>();
		for (GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()) {

			roles.add(ga.getAuthority());
		}
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);

		return params;

		/*
		 * 
		 * 
		 * user = securityContext.getAuthentication() ; listRoles = user.getRoles() ;
		 * 
		 * foms.findByName().getRoles ;
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

	}

}
