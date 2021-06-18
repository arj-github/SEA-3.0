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
	
	public List<Person> getAll4ServerTemplate() {
		this.testdaten();
		return personen;
	}

	public void delete(int id) {
		for (int i = 0; i < personen.size(); i++) {
			if (personen.get(i).getId() == id) {
				personen.remove(i);
			}
		}
	}
	
	public void update(Person person) {
		for (int i = 0; i < personen.size(); i++) {
			if (personen.get(i).getId() == person.getId()) {
				if (!(personen.get(i).getAnrede()!="")){
					personen.get(i).setAnrede(person.getAnrede());
				};
				if (!(personen.get(i).getVorname()!="")){
					personen.get(i).setVorname(person.getVorname());
				};
				if (!(personen.get(i).getNachname()!="")){
					personen.get(i).setNachname(person.getNachname());
				};
				if (!(personen.get(i).getEmail()!="")){
					personen.get(i).setEmail(person.getEmail());
				};
				if (!(personen.get(i).getStrasse()!="")){
					personen.get(i).setStrasse(person.getStrasse());
				};
				if (!(personen.get(i).getPLZ()!="")){
					personen.get(i).setPLZ(person.getPLZ());
				};
				if (!(personen.get(i).getOrt()!="")){
					personen.get(i).setOrt(person.getOrt());
				};
			}
		}
	}

	public void testdaten() {
		Person p1 = new Person(1,"Herr","Adam", "Adamson",  "a.a@my.de", "Lindenstr.", "11111", "Neudorf");
		Person p2 = new Person(2, "Frau","Eva", "Rippe", "e.r@x.de", "Sommerweg", "22222", "Halden");
		Person p3 = new Person(3, "Frau","Jackeline", "Adamson", "j.a@my.de", "Hauptstr", "33333", "Alten");
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
				
	}
}
