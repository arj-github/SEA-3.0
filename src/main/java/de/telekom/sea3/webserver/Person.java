package de.telekom.sea3.webserver;

import org.springframework.beans.factory.annotation.Autowired;

// So deklariert man eine Klasse mit Springboot

import org.springframework.stereotype.Component;

@Component // new Person();
public class Person {
	
	private Hund hund;
	private Katze katze;
	
	@Autowired
	public Person(Hund hund, Katze katze) {
		this.hund = hund; // ohne new? new Hund() --> Hund mit @Component in der Hund-Klasse
		this.katze = katze; // mit @Bean im WebServerConfig
		System.out.println("Hier wird UnnuetzAberZurPresentation erzeugt.");
		System.out.println(this.hund.toString());
		System.out.println(this.katze.toString());
		
	}

}
