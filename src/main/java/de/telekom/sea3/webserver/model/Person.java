package de.telekom.sea3.webserver.model;

public class Person {

	private int id;
	private String vorname;
	private String nachname;
	private String anrede;

	public Person(int i, String anrede, String vorname, String nachname) {
		this.id = i;
		this.anrede = anrede;
		this.vorname = vorname;
		this.nachname = nachname;
		// delete
		// update
		// eMail einbauen
		// Strasse PLZ Ort
		// Geburtsdatum
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}
}
