package ma.ac.ena.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.ena.entities.Etudiant;
import ma.ac.ena.services.EtudiantService;

@RestController
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;

	// @Secured(value = { "ROLE_ADMIN", "ROLE_SCOLARITE" })
	@PostMapping("/etudiants")
	public Etudiant saveEtudiant(@RequestBody @Valid Etudiant e) {
		return etudiantService.save(e);
	}

	// @RequestMapping(value = "/saveEtudiant")
	// public Etudiant saveEtudiant(Etudiant e) {
	// return etudiantService.save(e);
	// }

	// @Secured(value = { "ROLE_ADMIN", "ROLE_PROF", "ROLE_ETUDIANT",
	// "ROLE_SCOLARITE" })
	@GetMapping("/etudiants")
	public List<Etudiant> listEtudiant() {
		return etudiantService.findAll();
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
	}
}
