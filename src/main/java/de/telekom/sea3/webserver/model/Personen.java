package de.telekom.sea3.webserver.model;

import java.util.ArrayList;

import java.util.List;

public class Personen {

	private List<Person> personen = new ArrayList<Person>();

	public Personen(List<Person> all) {
		this.personen = all;
	}

	public List<Person> getPersonen() {
		return personen;
	}

	public void setPersonen(List<Person> personen) {
		this.personen = personen;
	}
	
	public void deletePerson(int id) {
		this.personen.remove(id);
	}

}
