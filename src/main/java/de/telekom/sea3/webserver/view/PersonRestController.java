package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Person;
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
	 * weiss Spring, dass wir aus der JavaKlasse Personen einen json-String machen wollen
	 * dazu deklarieren wir als rückgabewert Personen
	 * Spring leitet daraus ein json ab
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
	
	
	/**
	 * @GetMapping("/json/person/{id}")
	 * Für die Pathvariable "id" wird beim Aufruf ein Wert eingesetzt.
	 * Z.B. um das Element mit ID x zu wählen http://8080/json/person/x") 
	 * Die Annotation (@PathVariable("id") int id) vermittelt Spring das das Parameter aus der PathVariable stammt.
	 * hier haben wir beim @GetMapping statt persons - person in der URL geschrieben
	 * Grund - wir könnten als id "size" übergeben können
	 * dann würde die /json/persons/size URL aufgerufen und nicht die /json/person/{id} 
	 * @param id
	 * @return
	 */
	@GetMapping("/json/person/{id}")
	public Person getPerson(@PathVariable("id") int id) {
		return personService.get(id);
		
	}
	
	/**
	 * Mit @GetMapping - sind Personen-Daten nicht gut
	 * "/json/persons/add/{anrede}/{vorname}" weil die Namen in der URL vorkommen
	 * Das ist nicht der Fall mit Post
	 * @RequestBody liefert das komplette Body
	 * @param person
	 * @return
	 */
	@PostMapping("/json/person")
	public Person addPerson(@RequestBody Person person) {
		 return personService.add(person);
		
	}
	
	@DeleteMapping("/json/person/{id}")
	public void deletePerson(@PathVariable("id") int id) {
		personService.delete(id);
		
	}
		
}
