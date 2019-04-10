package ma.ac.ena.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.ac.ena.entities.RegisterForm;
import ma.ac.ena.entities.User;
import ma.ac.ena.services.UserService;
import ma.ac.ena.services.UsersRolesService;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;
	@Autowired
	private UsersRolesService usersRolesService;

	@RequestMapping(value = "/accueil.html")
	public String findUsers(Model model) {
		List<User> users = userService.findAllUsers();
		model.addAttribute("listUsers", users);
		return "accueil";
	}

	@GetMapping("register")
	public String a() {
		return "register";
	}

	@PostMapping(path = "/register")
	public User saveUser(RegisterForm registerForm) {
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
	//
	// @RequestMapping(path = "/register", method = RequestMethod.POST)
	// public String saveRegister(Model model, @ModelAttribute("registerForm")
	// @Validated RegisterForm registerForm,
	// BindingResult result, final RedirectAttributes redirectAttributes) {
	// if (!registerForm.getPassword().equals(registerForm.getRepassword())) {
	// throw new RuntimeException("Entrez le meme mot de passe pour confirmer");
	// }
	// User user = userService.findUserByUsername(registerForm.getUsername());
	// if (user != null) {
	// throw new RuntimeException("Ce nom d'utilisateur existe déjà");
	// }
	// User u = new User();
	//
	// try {
	// u.setUsername(registerForm.getUsername());
	// u.setPassword(registerForm.getPassword());
	// userService.saveUser(u);
	// }
	// // Other error!!
	// catch (Exception e) {
	// model.addAttribute("errorMessage", "Error: " + e.getMessage());
	// return "registerPage";
	// }
	// redirectAttributes.addFlashAttribute("flashUser", u);
	// // usersRolesService.addRoleToUser(registerForm.getUsername(), "USER");
	// return "registerPage";
	// }
}
