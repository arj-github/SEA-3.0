package de.telekom.sea3.webserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea3.webserver.model.*;
import de.telekom.sea3.webserver.repo.PersonRepository;
import de.telekom.sea3.webserver.repo.PersonRepositoryOhneDBAnbindung;

@Service
public class PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		System.out.println("PersonService instanziiert: " + this.toString());
		System.out.println("PersonRepository: " + personRepository.toString());
		this.personRepository = personRepository;
	}

//	public int getSize() {
//		//return personRepository.getSize();
//		return personRepository.
//	}
	
	public long count() {
		return personRepository.count();
		
	}

//	public Personen getAllPersons() {
//		return new Personen(personRepository.getAll());
//	}
//	
//	public List<Person> getAllPersons4ServerTemplate() {
//		return personRepository.getAll4ServerTemplate();
//	}
//
//	public Person add(Person person) {
//		personRepository.add(person);
//		return person;
//	}
//
//	public void delete(int id) {
//		personRepository.delete(id);
//	}
//	
//	public void update(Person person) {
//		personRepository.update(person);
//	}
//
//	public void testdaten() {
//		personRepository.testdaten();
//		
//	}
	
}
