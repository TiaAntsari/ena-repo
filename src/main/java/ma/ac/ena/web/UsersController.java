package ma.ac.ena.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/accueil.html", method = RequestMethod.GET)
	public String findUsers(Model model) {
		List<User> users = userService.findAllUsers();

		model.addAttribute("listUsers", users);
		return "accueil";
	}

	@GetMapping(path = "/deleteUser/{idUser}")
	public ModelAndView deleteUser(@PathVariable Long idUser) {
		userService.deleteUserById(idUser);
		return new ModelAndView("redirect:/accueil.html");
	}

	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public String listUsers(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Page<User> userPage = userService.findPageUser(PageRequest.of(currentPage - 1, pageSize));

		model.addAttribute("userPage", userPage);

		int totalPages = userPage.getTotalPages();

		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		return "/listUsers.html";
	}

	// @GetMapping("register")
	// public String registerPage() {
	// return "register";
	// }

	@PostMapping(path = "/register")
	public String saveUser(RegisterForm registerForm) {
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
		return "redirect:/accueil.html";
	}

	@RequestMapping(value = "/editUser/{idUser}")
	public String editUserPage(@PathVariable Long idUser, ModelMap model) {
		User user = userService.findUserById(idUser);
		model.addAttribute("user", user);
		return "editUser";
	}

	@RequestMapping(value = "/editUserSave", method = RequestMethod.POST)
	public ModelAndView editUserSave(@ModelAttribute("user") User u) {
		User user = userService.findUserById(u.getIdUser());

		user.setUsername(u.getUsername());
		// user.setPassword(u.getPassword());
		// user.setActivated(true);

		userService.saveUser(user);

		return new ModelAndView("redirect:/accueil.html");
	}

}
