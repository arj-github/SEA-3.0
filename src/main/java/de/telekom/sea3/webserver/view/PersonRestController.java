package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonRestController {
	
	private PersonService personService;
	
	// Verbindung der Klassen - personService zu PersonController
	@Autowired
	public PersonRestController(PersonService personService) {
		super(); 
		this.personService = personService;
	}
	
	/**
	 * @see URL: <a href="http://localhost:8080/json/persons/all">doku</a>
	 * ist nur ein Kommentar
	 * @return
	 */
	@GetMapping("/json/persons/all")
	@ResponseBody	// wir sagen Spring dass html kommt - gib an den Server
	public String getAllPersons() {
		
		Personen personen = personService.getAllPersons();
		personen.toJson();
		
		String string = "{\n"
				+ "	\"personen\": [\n"
				+ "		{\n"
				+ "			\"vorname\": \"Adamine\",\n"
				+ "			\"nachname\": \"Adamson\",\n"
				+ "			\"anrede\": \"Frau\"\n"
				+ "		},\n"
				+ "		{\n"
				+ "			\"vorname\": \"Bernd\",\n"
				+ "			\"nachname\": \"Braun\",\n"
				+ "			\"anrede\": \"Herr\"\n"
				+ "		},\n"
				+ "		{\n"
				+ "			\"vorname\": \"Franz\",\n"
				+ "			\"nachname\": \"Paulsen\",\n"
				+ "			\"anrede\": \"Herr\"\n"
				+ "		}\n"
				+ "	]\n"
				+ "}";
		return string;

	}
	
	@GetMapping("/json/persons/size")
	@ResponseBody	// wir sagen Spring dass html kommt - gib an den Server
	public String getSize() {
		
		int size = personService.getSize();
		
		String string = String.format("{\n"
				+ "	\"size\": %d\n"
				+ "}",size);
		return string;

	}
	
	
}
