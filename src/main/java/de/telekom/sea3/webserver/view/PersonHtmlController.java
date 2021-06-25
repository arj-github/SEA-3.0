package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonHtmlController {

	private PersonService personService;
	private static final String HTMLTEMPLATE = "<!DOCTYPE html> "
			+ "<html lang='de'>"
			+ "<head> <meta charset='utf-8'> "
			+ "<meta name='viewport' content='width=device-width, initial-scale=1.0'> "
			+ "<title>Titel</title> " + "</head> " + "<body>"
			+ "<h1>size: %d</h1></body>" + "</html>";

	@Autowired
	public PersonHtmlController(PersonService personService) {
		super();
		this.personService = personService;
	}

	// URL zum Aufrufen:"http://localhost:8080/size"
	@GetMapping("/size")
	@ResponseBody
	public String getSize() {
		String string = String.format(HTMLTEMPLATE, personService.count());
		return string;
	}
//
//	@GetMapping("/count")
//	public String getCount(Model model) {
//		String htmlFileName = "count";
//		String name = "Welt";
//		model.addAttribute("name", name);
//
//		return htmlFileName;
//	}
//	
//	@GetMapping("/size2")
//	public String getVarSize(Model model) {
//		model.addAttribute("sizeVar", personService.getSize());
//		return "size2";
//	}
//
//	// Die Variable "name"-siehe html-Seite count.html
//	// wird durch den Wert, den man im Aufruf über /?name=Wert
//	// übergeben wird
//	@GetMapping("/blub")
//	public String leseNameVonURL(Model model, 
//			@RequestParam(value = "name",required = false,defaultValue = "Default") String name ) {
//
//		model.addAttribute("name", name);
//		return "count";
//
//	}
//	// Aufruf: http://localhost:8080/blub/?name=BIBI
//	
//	
//	//Mölgich aber sinnlos, weil zur Statische Seiten führt
//	//Statische Seite, die auf ServerSeite gebaut wird
//	//Web-Seite - hier: /templates/personen.html
//	//model.addAttribute("ListenNameInPersonen.html", etwas Iterierbares!!!-hier-eine Liste! keine Referenz! )
//	//@ResponseBody - hier nicht notwendig, weil 
//	@GetMapping("/personenX")
//	public String personenMitTemplate(Model model){
//		
//		model.addAttribute("personsList", personService.getAllPersons4ServerTemplate());
//		return "personen";
//
//	}
//	
//	
//	
	
}
