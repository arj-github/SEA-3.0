package de.telekom.sea3.webserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Diese Klasse sagt nur aus dass eine
@Configuration
public class WebServerConfig {
	
	@Bean
	public Katze katze() /*throws InstantiationException, IllegalAccessException, ClassNotFoundException*/ {
		return new Katze();
		// return (Katze) Class.forName("sea.telekom.sea3.webserver").newInstance(); //-- gleichwertige Instanzerzeugung.
		// Class.forName - haben wir bei MariaDB Triber aufgerufen.
	}

}
