package com.movies.movie;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/movie")

public class MovieService {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public HashMap<Long,Movie> getAllMovies(){
			return Application.hmMovie;
	}

	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Movie addMovie(@RequestParam(value="title") String title
			, @RequestParam(value="description", defaultValue="unknown") String description) {
		Movie movie = new Movie(title,description);
		Application.hmMovie.put(new Long(movie.getId()),movie);
		return movie;
	}

	// Set Header like:key=Content-Type, value=application/json. Content-Type:application/json.
	// {"id": 11111111, "title":"New Title", "description":"New description"}
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Movie updateMovie(@RequestBody Movie movie) throws Exception{
		if(Application.hmMovie.containsKey(new Long(movie.getId()))){
			Application.hmMovie.put(new Long(movie.getId()), movie);
		}
		else { 
			throw new Exception("Movie "+ movie.getId()+ " doesn't exist");
		}
		return movie;
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public Movie deleteMovie(@PathVariable long id) throws Exception{
		Movie movie;
		
		if(Application.hmMovie.containsKey(new Long(id))) {
			movie=Application.hmMovie.get(new Long(id));
			Application.hmMovie.remove(new Long(id));
		}else {
			throw new Exception("Movie "+ id + " doesn't exist");
		}
		return movie;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Movie getMovie(@PathVariable long id) throws Exception{
		return Application.hmMovie.get(new Long(id));
	}
}

