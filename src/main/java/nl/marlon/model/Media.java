package nl.marlon.model;

import java.io.File;
import java.util.ArrayList;

public class Media {
	protected String title;
	protected String description;
	protected File thumbnail;
	protected String notes = "";
	protected ArrayList<Genre> genres = new ArrayList<>();

	// Notes and genres are optional

	// Full constructor
	public Media(String title, String description, File thumbnail, String notes, ArrayList<Genre> genres) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.notes = notes;
		this.genres = genres;
	}
	// Only one genre
	public Media(String title, String description, File thumbnail, String notes, Genre genre) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.notes = notes;
		genres.add(genre);
	}
	// No Genres
	public Media(String title, String description, File thumbnail, String notes) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.notes = notes;
	}
	// No Notes
	public Media(String title, String description, File thumbnail, ArrayList<Genre> genres) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.genres = genres;
	}
	// No Genres & Notes
	public Media(String title, String description, File thumbnail) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
	}
	@Override
	public String toString() {
		return "Media:"+ '\n' +
				"Title = " + title + '\n' +
				"Description = " + description + "\n" +
				"Thumbnail = " + thumbnail +"\n" +
				"Notes = " + notes + '\n' +
				"Genres = " + genres + '\n';
	}
}
