package ma.ac.ena.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.ac.ena.dao.FormsRepository;
import ma.ac.ena.entities.Forms;
import ma.ac.ena.services.FormsService;

public class FormsServiceImpl implements FormsService {

	@Autowired
	private FormsRepository formsRepository;

	@Override
	public Forms saveForms(Forms forms) {
		return formsRepository.save(forms);
	}

	@Override
	public List<Forms> findAllForms() {
		return formsRepository.findAll();
	}

	@Override
	public Forms findFormsByType(String type) {
		return formsRepository.findByType(type);
	}

	@Override
	public void deleteFormsByType(String type) {
		Forms forms = formsRepository.findByType(type);
		formsRepository.delete(forms);

	}

	@Override
	public void deleteFormsByIdForms(int idForms) {
		Forms forms = formsRepository.findByIdForms(idForms);
		formsRepository.delete(forms);

	}

	@Override
	public Forms findFormsByIdForms(int idForms) {
		return formsRepository.findByIdForms(idForms);
	}

}
