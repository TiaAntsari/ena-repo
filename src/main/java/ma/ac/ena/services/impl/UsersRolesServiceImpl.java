package ma.ac.ena.services.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ac.ena.dao.RoleRepository;
import ma.ac.ena.dao.UserRepository;
import ma.ac.ena.entities.Role;
import ma.ac.ena.entities.User;
import ma.ac.ena.services.UsersRolesService;

@Service
@Transactional
public class UsersRolesServiceImpl implements UsersRolesService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void addRoleToUser(String username, String roleName) {
		Role role = roleRepository.findByRole(roleName);
		User user = userRepository.findByUsername(username);
		user.getRoles().add(role);
	}

	@Override
	public Collection<Role> findRoleByUsername(String username) {
		User user = userRepository.findByUsername(username);
		Collection<Role> roles = user.getRoles();
		return roles;
	}

	@Override
	public void removeRoleToUser(String username, String roleName) {
		Role role = roleRepository.findByRole(roleName);
		User user = userRepository.findByUsername(username);
		user.getRoles().remove(role);
	}

}
