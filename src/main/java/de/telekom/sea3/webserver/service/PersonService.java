package de.telekom.sea3.webserver.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.model.*;
import de.telekom.sea3.webserver.repo.PersonRepository;

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

	public Size getSize() {
		return new Size(personRepository.count());
	}

	public Person get(long id) {
		Optional<Person> op = personRepository.findById((Long) id);
		Person person = op.get();

		if (person.equals(null)) {
			throw new NullPointerException();
		} else
			return person;
	}

	public long count() {
		return personRepository.count();

	}

	// ArrayList personen aufbauen
	public Personen getAllPersons() {
		Personen ps = new Personen();
		for (Person p : personRepository.findAll()) {
			ps.getPersonen().add(p);
		}
		return ps;
	}

	public Person add(Person person) {
		personRepository.save(person);
		return person;
	}

	public void delete(long id) {
		Optional<Person> op = personRepository.findById((Long) id);
		Person person = op.get();

		if (person.equals(null)) {
			throw new NullPointerException();
		} else
			personRepository.delete(person);
	}

	public void update(Person person) {
		personRepository.save(person);

	}

	public Person getPersonById(long id) {
		Optional<Person> op = personRepository.findById((Long) id);

		if (!op.equals(null)) {
			Person person = op.get();
			return person;
		}
		throw new NullPointerException();
	}

}
