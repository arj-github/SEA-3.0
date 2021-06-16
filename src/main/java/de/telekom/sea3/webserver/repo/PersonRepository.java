package de.telekom.sea3.webserver.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.Person;

@Repository
public class PersonRepository {

	private List<Person> personen = new ArrayList<Person>();

	public int getSize() {
		return personen.size();
	}

	public boolean add(Person person) {
		return personen.add(person);
	}

	public List<Person> getAll() {
		return personen;
	}

	public void delete(int id) {
		System.out.println(personen.size());	
		for (int i = 0; i < personen.size(); i++) {
			if (personen.get(i).getId() == id) {
				personen.remove(i);
			}
		System.out.println(personen.size());	
		}
	}
}
