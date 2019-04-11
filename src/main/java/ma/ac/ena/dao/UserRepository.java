package ma.ac.ena.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ena.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);

	public User findByIdUser(Long idUser);
}
