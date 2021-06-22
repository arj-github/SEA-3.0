package de.telekom.sea3.webserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="personen")
@Entity
public class Person {

	@Id
	private long id;
	@Column
	private String vorname;
	@Column
	private String nachname;
	@Column
	private String anrede;
	@Column
	private String email;
	@Column
	private String strasse;
	@Column
	private	String ort;
	@Column
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
