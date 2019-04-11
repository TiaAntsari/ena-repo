package ma.ac.ena.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ena.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	public Etudiant findByIdEtudiant(Long idEtudiant);
}
