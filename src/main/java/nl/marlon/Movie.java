package nl.marlon;

import java.awt.*;
import java.util.ArrayList;

public class Movie {
	private String title;
	private String description;
	private Image thumbnail;
	private String notes;
	private boolean seen;
	private String director;
	private ArrayList<Genre> genres;

	public Movie(String title, String description, Image thumbnail, String notes, boolean seen, String director) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.notes = notes;
		this.seen = seen;
		this.director = director;
	}
	public Movie(String title, String description, Image thumbnail, String notes, boolean seen) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.notes = notes;
		this.seen = seen;
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

	public Image getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
}
