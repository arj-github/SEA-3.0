package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	private static final String HTMLTEMPLATE = "<!DOCTYPE html> <html lang='de'>"
			+ " <head> <meta charset='utf-8'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Titel</title> </head> "
			+ " <body>size: %d</body> </html>";
	
	// Verbindung der Klassen - personService zu PersonController
	@Autowired
	public PersonController(PersonService personService) {
		super();
		System.out.println("PersonController instanziiert: " + this.toString());
		System.out.println("PersonController: " + personService.toString());
		this.personService = personService;
	}
	
	// @GetMapping bestimmt wie die Methode aufgerufen wird
	// URL zum Aufrufen:"http://localhost:8080/size" 
	@GetMapping("/size")
	@ResponseBody	// wir sagen Spring dass das in das Resposne in das http request 
	public String getSize() {
		// einige Möglichkeiten wie man aus int einen String machen kann
//		String string1 = String.valueOf(0);
//		String string2 = "" + personService.getSize();
//		String string3 = String.format("%d",personService.getSize());
//		String string4 = Integer.toString(personService.getSize());
		String string5 = String.format(HTMLTEMPLATE,personService.getSize());
		
		return string5;
	}
}
