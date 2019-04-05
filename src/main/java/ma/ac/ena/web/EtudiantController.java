package ma.ac.ena.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.ena.entities.Etudiant;
import ma.ac.ena.services.EtudiantService;

@RestController
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;

	@Secured(value = { "ROLE_ADMIN", "ROLE_SCOLARITE" })
	@RequestMapping(value = "/saveEtudiant", method = RequestMethod.GET)
	public Etudiant saveEtudiant(Etudiant e) {
		return etudiantService.save(e);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_PROF", "ROLE_ETUDIANT", "ROLE_SCOLARITE" })
	@RequestMapping(value = "/etudiants")
	public List<Etudiant> listEtudiant() {
		return etudiantService.findAll();
	}

}
