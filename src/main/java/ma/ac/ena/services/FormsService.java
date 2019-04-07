package ma.ac.ena.services;

import java.util.List;

import ma.ac.ena.entities.Forms;

public interface FormsService {
	public Forms saveForms(Forms forms);

	public List<Forms> findAllForms();

	public Forms findFormsByType(String type);
}
