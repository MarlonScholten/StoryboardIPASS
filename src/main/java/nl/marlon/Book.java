package nl.marlon;

import java.io.File;
import java.util.ArrayList;

public class Book extends Media{
	private int page;
	private String author;

	// Full constructor
	public Book(String title, String description, File thumbnail, String notes, ArrayList<Genre> genres, int page, String author) {
		super(title, description, thumbnail, notes, genres);
		this.author = author;
		this.page = page;
	}
	// No Genres
	public Book(String title, String description, File thumbnail, String notes, int page, String author) {
		super(title, description, thumbnail, notes);
		this.author = author;
		this.page = page;
	}
	// No Notes
	public Book(String title, String description, File thumbnail, ArrayList<Genre> genres, int page, String author) {
		super(title, description, thumbnail, genres);
		this.author = author;
		this.page = page;
	}
	// No Genres & Notes
	public Book(String title, String description, File thumbnail, int page, String author) {
		super(title, description, thumbnail);
		this.author = author;
		this.page = page;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
}
