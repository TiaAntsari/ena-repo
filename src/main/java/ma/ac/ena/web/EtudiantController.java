package ma.ac.ena.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	@PostMapping("/inscription")
	public Etudiant saveEtudiant1(@RequestBody @Valid Etudiant e) {
		return etudiantService.save(e);
	}

	// @RequestMapping(value = "/saveEtudiant")
	// public Etudiant saveEtudiant(Etudiant e) {
	// return etudiantService.save(e);
	// }

	// @Secured(value = { "ROLE_ADMIN", "ROLE_PROF", "ROLE_ETUDIANT",
	// "ROLE_SCOLARITE" })
	@GetMapping("/etudiants1")
	public List<Etudiant> listEtudiant() {
		return etudiantService.findAll();
	}

}
