package ma.ac.ena.services;

import java.util.List;

import ma.ac.ena.entities.Forms;

public interface FormsService {
	public Forms saveForms(Forms forms);

	public void deleteForms(String type);

	public List<Forms> findAllForms();

	public Forms findFormsByType(String type);
}
