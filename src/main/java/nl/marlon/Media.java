package nl.marlon;

import java.awt.*;
import java.util.ArrayList;

public class Media {
	private String title;
	private String description;
	private Image thumbnail;
	private String notes;
	private ArrayList<Genre> genres;

	// To do: make constructors for genres or no genres

	// DEV NOTE: An image is required in production! for development there will be a constrcutor without image
	// Notes are optional

	// Full constructor
	public Media(String title, String description, Image thumbnail, String notes) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.notes = notes;
	}
	// (DEV ONLY) No Thumbnail
	public Media(String title, String description, String notes) {
		this.title = title;
		this.description = description;
		this.notes = notes;
	}
	// No notes & image
	public Media(String title, String description) {
		this.title = title;
		this.description = description;
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
}
