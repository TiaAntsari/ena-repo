package ma.ac.ena.services.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ac.ena.dao.UserRepository;
import ma.ac.ena.entities.User;
import ma.ac.ena.services.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User saveUser(User user) {
		String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPassword);
		return userRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void deleteUserByUsername(String username) {
		User user = userRepository.findByUsername(username);

		userRepository.delete(user);
	}

	@Override
	public Page<User> findPageUser(Pageable pageable) {
		List<User> users = userRepository.findAll();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		List<User> list;
		if (users.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, users.size());
			list = users.subList(startItem, toIndex);
		}
		Page<User> userPage = new PageImpl<User>(list, PageRequest.of(currentPage, pageSize), users.size());
		return userPage;
	}

	@Override
	public void deleteUserById(Long idUser) {
		userRepository.deleteById(idUser);

	}

	@Override
	public User findUserById(Long idUser) {
		return userRepository.findByIdUser(idUser);
	}

}
