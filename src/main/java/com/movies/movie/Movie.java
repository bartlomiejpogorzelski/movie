package com.movies.movie;

import java.util.Date;


public class Movie {
	private long id;
	private String title;
	private String description;
	
	public Movie() {
	}
	
	public Movie(String title, String description) {
		this.id = (new Date()).getTime();
		this.title = title;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Movie{"+
				"id=" + id +
				", title='"+ title + '\'' +
				", description='"+ description + '\''+
				'}';
	}
	
	
}
