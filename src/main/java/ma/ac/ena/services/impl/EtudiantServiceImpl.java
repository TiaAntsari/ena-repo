package ma.ac.ena.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ac.ena.dao.EtudiantRepository;
import ma.ac.ena.entities.Etudiant;
import ma.ac.ena.services.EtudiantService;

@Service
@Transactional
public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	private EtudiantRepository etudianRepository;

	@Override
	public Etudiant save(Etudiant e) {
		return etudianRepository.save(e);
	}

	@Override
	public List<Etudiant> findAll() {
		return etudianRepository.findAll();
	}

}
