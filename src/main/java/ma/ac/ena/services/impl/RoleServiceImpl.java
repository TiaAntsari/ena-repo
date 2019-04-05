package ma.ac.ena.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ac.ena.dao.RoleRepository;
import ma.ac.ena.entities.Role;
import ma.ac.ena.services.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role save(Role r) {
		return roleRepository.save(r);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

}
