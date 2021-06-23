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

		var anrede = person.getAnrede();
		var vorname = person.getVorname();
		var nachname = person.getNachname();
		LocalDate gebDatum = person.getGebDatum();
		var email = person.getEmail();
		var str = person.getStrasse();
		var plz = person.getPlz();
		var ort = person.getOrt();
		var version = person.getVersion();

		System.out.println(anrede);
		System.out.println(vorname);
		System.out.println(nachname);
		DateTimeFormatter formGebDate = DateTimeFormatter.ofPattern("ddLLLLyyyy");
		String gebDateString = gebDatum.format(formGebDate);
		System.out.println(gebDateString);
		System.out.println(email);
		System.out.println(str);
		System.out.println(plz);
		System.out.println(ort);		
		System.out.println(version);
		

		Optional<Person> op = personRepository.findById((Long) person.getId());
		Person personToBeSaved = op.get();

		System.out.println("PersonToBeSaved: " + personToBeSaved);

		if (personToBeSaved.equals(null)) {
			throw new NullPointerException();
		} else if (!anrede.equals("")) {
			personToBeSaved.setAnrede(anrede);
		}
		
		if (!vorname.equals("")) {
			System.out.println("Hallo");
			personToBeSaved.setVorname(vorname);
		}

		if (!nachname.equals("")) {
			personToBeSaved.setNachname(nachname);
		}

		if (!email.equals("")) {
			personToBeSaved.setEmail(email);
		}

		if (!str.equals("")) {
			personToBeSaved.setStrasse(str);
		}
		if (!plz.equals("")) {
			personToBeSaved.setPlz(plz);
		}

		if (!ort.equals("")) {
			personToBeSaved.setOrt(ort);
		}

		if (!gebDatum.equals(null)) {
			personToBeSaved.setGebDatum(gebDatum);
		}
			personToBeSaved.setVersion(version);


		personRepository.save(personToBeSaved);

	}

	public Personen getPersonById(long id) {
		Personen ps = new Personen();
		Optional<Person> op = personRepository.findById((Long) id);

		if (!op.equals(null)) {
			Person personFound = op.get();
			ps.getPersonen().add(personFound);
			return ps;
		}
		throw new NullPointerException();
	}

}
