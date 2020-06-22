package nl.marlon.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Media {
	protected String id = UUID.randomUUID().toString();
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

	public File getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(File thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ArrayList<Genre> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}

	public String getId() {
		return id;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Media media = (Media) o;
		return id.equals(media.id) &&
				Objects.equals(title, media.title) &&
				Objects.equals(description, media.description) &&
				Objects.equals(thumbnail, media.thumbnail) &&
				Objects.equals(notes, media.notes) &&
				Objects.equals(genres, media.genres);
	}
}
