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

	@RequestMapping("/register")
	public String registerPage() {
		return "register";
	}
}
