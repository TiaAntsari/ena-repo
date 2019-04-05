package ma.ac.ena.services;

import java.util.List;

import ma.ac.ena.entities.Etudiant;

public interface EtudiantService {
	Etudiant save(Etudiant e);

	List<Etudiant> findAll();
}
