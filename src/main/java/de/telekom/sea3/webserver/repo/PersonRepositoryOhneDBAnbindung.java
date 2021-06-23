package de.telekom.sea3.webserver.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.Person;

@Repository
public class PersonRepositoryOhneDBAnbindung {

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
		for (int i = 0; i < personen.size(); i++) {
			if (personen.get(i).getId() == id) {
				personen.remove(i);
			}
		}
	}
	
	public void update(Person person) {
		for (int i = 0; i < personen.size(); i++) {
			if (personen.get(i).getId() == person.getId()) {
				var anrede=person.getAnrede();
				var vorname=person.getVorname();
				var nachname=person.getNachname();
				var email=person.getEmail();
				var str=person.getStrasse();
				var plz=person.getPLZ();
				var ort=person.getOrt();
				var gebDatum=person.getGebDatum();
			
				if (!anrede.equals("")){
					System.out.println(person.getAnrede());
					personen.get(i).setAnrede(anrede);
				};
				if (!vorname.equals("")){
					System.out.println("Hallo");
					personen.get(i).setVorname(vorname);
				};
				if (!nachname.equals("")){
					personen.get(i).setNachname(nachname);
				};
				if (!email.equals("")){
					personen.get(i).setEmail(email);
				};
				if (!str.equals("")){
					personen.get(i).setStrasse(str);
				};
				if (!plz.equals("")){
					personen.get(i).setPLZ(plz);
				};
				if (!ort.equals("")){
					personen.get(i).setOrt(ort);
				};
				if (!gebDatum.equals(null)){
					personen.get(i).setGebDatum(gebDatum);
				};
			}
		}
	}
	
	
	// Dieser Teil war wichtig für Testdaten bei fehlender DB-Persistierung
//	public List<Person> getAll4ServerTemplate() {
//	this.testdaten();
//	return personen;
//}
	

//	public void testdaten() {
//		Person p1 = new Person(1,"Herr","Adam", "Adamson",  "a.a@my.de", "Lindenstr.", "11111", "Neudorf");
//		Person p2 = new Person(2, "Frau","Eva", "Rippe", "e.r@x.de", "Sommerweg", "22222", "Halden");
//		Person p3 = new Person(3, "Frau","Jackeline", "Adamson", "j.a@my.de", "Hauptstr", "33333", "Alten");
//		
//		this.add(p1);
//		this.add(p2);
//		this.add(p3);
//				
//	}
}
