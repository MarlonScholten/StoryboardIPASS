package nl.marlon;

import java.io.File;
import java.util.ArrayList;

public class Movie extends Media {
	private String director;
	private boolean seen;

	// Full constructor
	public Movie(String title, String description, File thumbnail, String notes, ArrayList<Genre> genres, String director, boolean seen) {
		super(title, description, thumbnail, notes, genres);
		this.director = director;
		this.seen = seen;
	}
	// No Genres
	public Movie(String title, String description, File thumbnail, String notes, String director, boolean seen) {
		super(title, description, thumbnail, notes);
		this.director = director;
		this.seen = seen;
	}
	// No Notes
	public Movie(String title, String description, File thumbnail, ArrayList<Genre> genres, String director, boolean seen) {
		super(title, description, thumbnail, genres);
		this.director = director;
		this.seen = seen;
	}
	// No Genres & Notes
	public Movie(String title, String description, File thumbnail, String director, boolean seen) {
		super(title, description, thumbnail);
		this.director = director;
		this.seen = seen;
	}
}
