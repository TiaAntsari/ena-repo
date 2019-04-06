package ma.ac.ena.services;

import java.util.List;

import ma.ac.ena.entities.User;

public interface UserService {
	public User saveUser(User u);

	public List<User> findAllUsers();

	public User findUserByUsername(String username);
}
