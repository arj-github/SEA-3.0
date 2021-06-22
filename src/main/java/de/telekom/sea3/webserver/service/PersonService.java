package de.telekom.sea3.webserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//	public int getSize() {
//		//return personRepository.getSize();
//		return personRepository.
//	}
	
	public Person get(long id) {
		Optional<Person> op= personRepository.findById((Long) id);
		Person person = op.get();
		
		if (person.equals(null)) {
			throw new NullPointerException();
		} else return person;
	}
	
	public long count() {
		return personRepository.count();
		
	}

	// ArrayList personen aufbauen
	public Personen getAllPersons() {
		Personen ps = new Personen();
			for (Person p:personRepository.findAll()) {
				ps.getPersonen().add(p);
			}
			return ps;
	}
	

	public Person add(Person person) {
		personRepository.save(person);
		return person;
	}

	public void delete(long id) {
		Optional<Person> op = personRepository.findById((Long) id );
		Person person = op.get();
		
		if (person.equals(null)) {
			throw new NullPointerException();
		} else personRepository.delete(person);
	}
	
	public void update(Person person) {
		
		var anrede=person.getAnrede();
		var vorname=person.getVorname();
		var nachname=person.getNachname();
		var email=person.getEmail();
		var str=person.getStrasse();
		var plz=person.getPLZ();
		var ort=person.getOrt();
		
		Optional<Person> op = personRepository.findById((Long) person.getId() );
		Person personToBeSaved = op.get();
		
		if (personToBeSaved.equals(null)) {
			throw new NullPointerException();
		} else
			if (!anrede.equals("")){
				personToBeSaved.setAnrede(anrede);
			};
			if (!vorname.equals("")){
				System.out.println("Hallo");
				personToBeSaved.setVorname(vorname);
			};
			if (!nachname.equals("")){
				personToBeSaved.setNachname(nachname);
			};
			if (!email.equals("")){
				personToBeSaved.setEmail(email);
			};
			if (!str.equals("")){
				personToBeSaved.setStrasse(str);
			};
			if (!plz.equals("")){
				personToBeSaved.setPLZ(plz);
			};
			if (!ort.equals("")){
				personToBeSaved.setOrt(ort);
			};
			personRepository.save(personToBeSaved);
		
		}

	public Personen getPersonById(long id) {
		Personen ps = new Personen();
		Optional<Person> op = personRepository.findById((Long) id); 
		
		if (!op.equals(null)) {
			Person personFound = op.get();
			ps.getPersonen().add(personFound);
			return ps;
		} throw new NullPointerException();
	}
	
}
