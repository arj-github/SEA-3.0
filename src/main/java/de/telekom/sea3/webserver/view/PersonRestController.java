package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.model.Size;
import de.telekom.sea3.webserver.service.PersonService;

@RestController
public class PersonRestController {
	
	private PersonService personService;
	
	// Verbindung der Klassen - personService zu PersonController
	@Autowired
	public PersonRestController(PersonService personService) {
		super(); 
		this.personService = personService;
	}
	
	/**
	 * Durch die Annotation der Klasse @RestController
	 * weiss Spring, dass wir aus der JavaKlasse Personen einen json-String wollen
	 * dazu deklarieren wir als rückgabewert Personen
	 * Spring wandelt daraus ein json
	 */
	@GetMapping("/json/persons/all")
	public Personen getAllPersons() {
		
		Personen personen = personService.getAllPersons();
		return personen;

	}
	
	@GetMapping("/json/persons/size")
	public Size getSize() {

		return new Size(personService.getSize());
		
	}
	
	
}
