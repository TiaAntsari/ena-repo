package ma.ac.ena.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ena.entities.Forms;

public interface FormsRepository extends JpaRepository<Forms, Integer> {
	public Forms findByType(String type);
}
