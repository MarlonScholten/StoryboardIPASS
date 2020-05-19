package nl.marlon;

import java.io.File;
import java.util.ArrayList;

public class Show extends Media {
	private int season;
	private int episode;

	// Full constructor
	public Show(String title, String description, File thumbnail, String notes, ArrayList<Genre> genres, int season, int episode) {
		super(title, description, thumbnail, notes, genres);
		this.season = season;
		this.episode = episode;
	}
	// No Genres
	public Show(String title, String description, File thumbnail, String notes, int season, int episode) {
		super(title, description, thumbnail, notes);
		this.season = season;
		this.episode = episode;
	}
	// No Notes
	public Show(String title, String description, File thumbnail, ArrayList<Genre> genres, int season, int episode) {
		super(title, description, thumbnail, genres);
		this.season = season;
		this.episode = episode;
	}
	// No Genres & Notes
	public Show(String title, String description, File thumbnail, int season, int episode) {
		super(title, description, thumbnail);
		this.season = season;
		this.episode = episode;
	}
}
