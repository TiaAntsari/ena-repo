package ma.ac.ena.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.ac.ena.services.EtudiantService;
import ma.ac.ena.services.UserService;

@Controller
public class WebController {

	@Autowired
	private UserService userService;
	@Autowired
	private EtudiantService etudiantService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}

	@RequestMapping("/inscription")
	public String inscriptionPage() {
		return "inscription";
	}

	// @RequestMapping("/index")
	// public String index(Model model) {
	// List<User> users = userService.findAllUsers();
	// model.addAttribute("listUsers", users);
	// return "users";
	// }
	//
	// @RequestMapping("/index")
	// public String etudiant(Model model) {
	// List<Etudiant> etudiants = etudiantService.findAll();
	// model.addAttribute("listEtudiants", etudiants);
	// return "users";
	// }
}
