package edu.ccsu.sped.workflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccsu.sped.workflow.models.Persons;
import edu.ccsu.sped.workflow.repos.PersonsRepository;

@Service
public class PersonsService {

	@Autowired
	private PersonsRepository personsRepository;
	
	// GET all 
	public List<Persons> getPersons() {
		return (List<Persons>) personsRepository.findAll();
	}
	
	// GET single instance
	public Optional<Persons> getPersonById(Integer Id) {
		return personsRepository.findById(Id);
	}
	
	// POST new instance
	public void addPerson(Persons persons) {
		personsRepository.save(persons);
	}
	
	// PUT single existing instance to update
	public void updatePerson(Persons persons) {
		personsRepository.save(persons);
	}
	
	// DELETE single instance
	public void deletePersonById(Integer Id) {
		personsRepository.deleteById(Id);
	}
	
}
