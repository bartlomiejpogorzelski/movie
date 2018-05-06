package com.movies.movie;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static HashMap<Long, Movie> hmMovie;
	
	public static void main(String[] args) {
		
		hmMovie=new HashMap<Long,Movie>();
				
		Movie one = new Movie("Killer", "Jerzy Kiler, warszawski taksówkarz, przypadkowo zostaje wzięty za płatnego zabójcę i umieszczony w areszcie. "
				+ "Wyciąga go stamtąd boss świata przestępczego, który oferuje mu nowe zadanie.");
		hmMovie.put(new Long(one.getId()), one);
		
		SpringApplication.run(Application.class, args);
		
		Movie two = new Movie("Psy", "Franz Maurer, były funkcjonariusz Służby Bezpieczeństwa,"
				+ " zaczyna pracę w policji. Tymczasem jego kolega oferuje swoje usługi przestępcom");
		hmMovie.put(new Long(two.getId()), two);

	}
	

}
