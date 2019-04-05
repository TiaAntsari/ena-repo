package ma.ac.ena.services;

import java.util.List;

import ma.ac.ena.entities.User;

public interface UserService {
	User save(User u);

	List<User> findAll();
}
