package de.telekom.sea3.webserver.model;

public class Person {

	private int id;
	private String vorname;
	private String nachname;
	private String anrede;
	private String eMail;
	private String strasse;
	private	String ort;
	private String plz;
	private String geburtsdatum;

	
	public Person() {};
	public Person(int i, String anrede, String vorname, String nachname) {
		this.id = i;
		this.anrede = anrede;
		this.vorname = vorname;
		this.nachname = nachname;
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
	
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
}
