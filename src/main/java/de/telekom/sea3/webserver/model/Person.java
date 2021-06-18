package de.telekom.sea3.webserver.model;

public class Person {

	private int id;
	private String vorname;
	private String nachname;
	private String anrede;
	private String email;
	private String strasse;
	private	String ort;
	private String plz;

	
	public Person() {};
	public Person(int i, String anrede, String vorname, String nachname,
			String email, String strasse, String plz, String ort) {
		this.id = i;
		this.anrede = anrede;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;

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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPLZ() {
		return plz;
	}
	public void setPLZ(String plz) {
		this.plz = plz;
	}

}
