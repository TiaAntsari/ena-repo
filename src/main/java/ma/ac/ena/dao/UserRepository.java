package ma.ac.ena.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ena.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	public User findByUsername(String username);
}
