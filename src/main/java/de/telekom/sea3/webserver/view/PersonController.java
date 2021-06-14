package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonController {
	private PersonService personService;
	
	// Verbindung der Klassen - personService zu PersonController
	@Autowired
	public PersonController(PersonService personService) {
		super();
		System.out.println("PersonController instanziiert: " + this.toString());
		System.out.println("PersonController: " + personService.toString());
		this.personService = personService;
	}
	
}
