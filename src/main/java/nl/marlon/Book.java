package nl.marlon;

import java.awt.*;
import java.util.ArrayList;

public class Book {
	private String title;
	private String description;
	private Image thumbnail;
	private String notes;
	private int page;
	private String author;
	private ArrayList<Genre> genres;

	public Book(String title, String description, Image thumbnail, String notes, int page, String author) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.notes = notes;
		this.page = page;
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
}
