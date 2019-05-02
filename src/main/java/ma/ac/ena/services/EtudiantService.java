package ma.ac.ena.services;

import java.util.List;

import ma.ac.ena.entities.Etudiant;

public interface EtudiantService {
	public Etudiant save(Etudiant e);

	public List<Etudiant> findAll();

	public void deleteEtudiantByIdEtudiant(long idEtudiant);
}
