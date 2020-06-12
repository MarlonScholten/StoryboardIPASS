package nl.marlon.model;

import java.io.File;
import java.util.ArrayList;

public class Movie extends Media {
	private String director;
	private boolean watched;

	// Full constructor
	public Movie(String title, String description, File thumbnail, String notes, ArrayList<Genre> genres, String director, boolean watched) {
		super(title, description, thumbnail, notes, genres);
		this.director = director;
		this.watched = watched;
	}
	// No Genres
	public Movie(String title, String description, File thumbnail, String notes, String director, boolean watched) {
		super(title, description, thumbnail, notes);
		this.director = director;
		this.watched = watched;
	}
	// No Notes
	public Movie(String title, String description, File thumbnail, ArrayList<Genre> genres, String director, boolean watched) {
		super(title, description, thumbnail, genres);
		this.director = director;
		this.watched = watched;
	}
	// No Genres & Notes
	public Movie(String title, String description, File thumbnail, String director, boolean watched) {
		super(title, description, thumbnail);
		this.director = director;
		this.watched = watched;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public boolean isWatched() {
		return watched;
	}

	public void setWatched(boolean watched) {
		this.watched = watched;
	}

	@Override
	public String toString() {
		return super.toString() +
				"Type: " + this.getClass().getSimpleName() + "\n" +
				"Director: " + director + "\n" +
				"Watched: " + watched + "\n";
	}
}
